# AutoReplaceTool

### Description:
AutoReplaceTool is a simple, lightweight PaperMC plugin that automatically replaces a broken tool or weapon on your hotbar with another matching item from your inventory.

### Features
- **Automatic replacement:** When a tool or weapon breaks in your hotbar, the plugin searches your inventory for another of the same type and instantly replaces it in the same slot.
- **Seamless gameplay:** No need to open your inventory or interrupt your mining/fighting flow.
- **Zero configuration:** Just drop it into your plugins/ folder—no setup required.
- **Lightweight:** No permissions, commands, or performance overhead.
- **Compatible with Paper 1.21.7** (and likely older and newer 1.21.x versions).

### How it Works
Whenever a tool or weapon in your hotbar breaks:
1. The plugin detects the break event.
2. It searches the rest of your inventory for another matching item (same type).
3. If found, the new item is instantly moved to your hotbar slot, so you can keep playing without interruption.

### Installation
1. Download the latest release of AutoReplaceTool from the releases page.
2. Place the .jar file in your Minecraft server’s plugins/ directory.
3. Start or restart your server.

#### License:
This project is licensed under the MIT License.