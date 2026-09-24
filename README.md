# AutoReplaceTool

### Description
AutoReplaceTool is a simple, lightweight PaperMC plugin that automatically replaces a broken tool or weapon on your hotbar with another matching item from your inventory.

### Features
- **Automatic replacement:** When a supported tool or weapon breaks in your hotbar, the plugin searches the inventory for another one and instantly replaces it in the same slot.
- **Tier fallback:** If no identical item is available, the highest-tier lower-grade replacement is selected (for example, diamond to iron).
- **Seamless gameplay:** No need to open your inventory or interrupt your mining/fighting flow.
- **Zero configuration:** Just drop it into your plugins/ folder—no setup required.
- **Lightweight:** No permissions, commands, or performance overhead.
- **Paper-first support:** Built for Paper 26.3 using the Paper API; Bukkit and Spigot are not primary targets.

### How it Works
Whenever a tool or weapon in your hotbar breaks:
1. The plugin detects the break event.
2. It searches the inventory for an identical item.
3. If none is available, it searches for the highest-tier lower-grade item in the same tool or weapon family.
4. If found, the replacement is moved to your hotbar slot, so you can keep playing without interruption.

### Installation
1. Download the latest release of AutoReplaceTool from the releases page.
2. Place the .jar file in your Minecraft server’s plugins/ directory.
3. Start or restart your server.

### Compatibility

AutoReplaceTool 0.1.0 targets Paper 26.3 and requires Java 25. The build currently uses `paper-api:26.3.build.38-alpha`. Paper is the primary supported server platform; Bukkit and Spigot compatibility is not guaranteed.

### License
This project is licensed under the MIT License.
