AutoReplaceTool Change Log
------------------------------------------------------------

AutoReplaceTool v0.1.0
- Added lower-tier fallback replacement for pickaxes, axes, shovels, hoes, and swords.
- Preferred an exact-material replacement over a lower-tier replacement.
- Searched all inventory slots except the broken hotbar slot for replacements.
- Upgraded the build target to Java 25 for Minecraft 26.x / Paper 26.3.
- Upgraded the Paper API dependency to 26.3.
- Upgraded plugin metadata to API version 26.3.
- Upgraded Maven Compiler Plugin to 3.16.0.
- Upgraded Maven Shade Plugin to 3.6.2 for Java 25 bytecode support.
- Used Paper as the primary supported server platform; Bukkit and Spigot compatibility was not guaranteed.
- Required no configuration or permissions.
