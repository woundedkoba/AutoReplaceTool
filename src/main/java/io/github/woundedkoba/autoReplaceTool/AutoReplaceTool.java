package io.github.woundedkoba.autoReplaceTool;

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

        // Search for another of the same type
        for (int i = 9; i < inv.getSize(); i++) {
            ItemStack stack = inv.getItem(i);
            if (stack != null && stack.getType() == brokenType && stack.getAmount() > 0) {
                inv.setItem(slot, stack.clone());
                stack.setAmount(0); // Remove from original
                break;
            }
        }
    }
}
