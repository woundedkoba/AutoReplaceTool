package io.github.woundedkoba.autoreplacetool;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoReplaceTool extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("AutoReplaceTool enabled!");
    }

    @EventHandler
    public void onItemBreak(PlayerItemBreakEvent event) {
        PlayerInventory inv = event.getPlayer().getInventory();
        int slot = inv.getHeldItemSlot();

        if (slot < 0 || slot > 8) return;

        Material brokenType = event.getBrokenItem().getType();

        int replacementSlot = findReplacementSlot(inv, slot, brokenType);
        if (replacementSlot >= 0) {
            ItemStack replacement = inv.getItem(replacementSlot);
            inv.setItem(slot, replacement.clone());
            inv.setItem(replacementSlot, null);
        }
    }

    private int findReplacementSlot(PlayerInventory inventory, int brokenSlot, Material brokenType) {
        int brokenTier = tierOf(brokenType);
        String brokenFamily = familyOf(brokenType);
        int bestSlot = -1;
        int bestTier = -1;

        for (int i = 0; i < inventory.getSize(); i++) {
            if (i == brokenSlot) continue;

            ItemStack stack = inventory.getItem(i);
            if (stack == null || stack.getAmount() <= 0) continue;

            Material candidate = stack.getType();
            if (candidate == brokenType) return i;
            if (brokenTier < 0 || !brokenFamily.equals(familyOf(candidate))) continue;

            int candidateTier = tierOf(candidate);
            if (candidateTier >= 0 && candidateTier < brokenTier && candidateTier > bestTier) {
                bestSlot = i;
                bestTier = candidateTier;
            }
        }

        return bestSlot;
    }

    private String familyOf(Material material) {
        String name = material.name();
        String[] families = {"PICKAXE", "AXE", "SHOVEL", "HOE", "SWORD"};
        for (String family : families) {
            if (name.endsWith("_" + family)) return family;
        }
        return "";
    }

    private int tierOf(Material material) {
        return switch (material.name().split("_")[0]) {
            case "WOODEN" -> 0;
            case "STONE" -> 1;
            case "IRON" -> 2;
            case "GOLDEN" -> 3;
            case "DIAMOND" -> 4;
            case "NETHERITE" -> 5;
            default -> -1;
        };
    }
}
