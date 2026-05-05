package com.devcaiqueoliveira.bweaponsandtools;

import com.devcaiqueoliveira.bweaponsandtools.command.WeaponGiveCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class BWeaponsAndToolsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        saveConfig();

        getCommand("weapon").setExecutor(new WeaponGiveCommand(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
