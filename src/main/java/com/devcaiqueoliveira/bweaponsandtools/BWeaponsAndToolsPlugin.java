package com.devcaiqueoliveira.bweaponsandtools;

import com.devcaiqueoliveira.bweaponsandtools.command.WeaponCommand;
import com.devcaiqueoliveira.bweaponsandtools.config.Config;
import com.devcaiqueoliveira.bweaponsandtools.config.WeaponLoader;
import com.devcaiqueoliveira.bweaponsandtools.registry.WeaponRegistry;
import com.devcaiqueoliveira.bweaponsandtools.service.WeaponService;
import org.bukkit.plugin.java.JavaPlugin;

public final class BWeaponsAndToolsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        saveConfig();

        Config configWeapons = new Config(this, "weapons.yml");

        WeaponRegistry weaponRegistry = new WeaponRegistry();

        WeaponLoader loader = new WeaponLoader(weaponRegistry, configWeapons);
        loader.load();

        WeaponService weaponService = new WeaponService(weaponRegistry, loader);

        getCommand("weapon").setExecutor(new WeaponCommand(this, weaponService));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
