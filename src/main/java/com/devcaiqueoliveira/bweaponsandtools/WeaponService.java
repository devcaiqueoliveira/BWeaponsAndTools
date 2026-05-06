package com.devcaiqueoliveira.bweaponsandtools;

import com.devcaiqueoliveira.bweaponsandtools.config.Config;
import com.devcaiqueoliveira.bweaponsandtools.config.WeaponLoader;
import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import com.devcaiqueoliveira.bweaponsandtools.registry.WeaponRegistry;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeaponService {

    private final WeaponRegistry weaponRegistry;
    private final WeaponLoader loader;

    public Weapon getWeapon(String name) {
        return weaponRegistry.getWeapon(name.toUpperCase());
    }

    public void reloadConfig() {
        loader.load();
    }

}
