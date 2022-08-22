package com.github.ytshiyugh.diamondrandomplace;

import org.bukkit.plugin.java.JavaPlugin;

public final class DiamondRandomPlace extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("fdp").setExecutor(new FindDiamondPlace());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
