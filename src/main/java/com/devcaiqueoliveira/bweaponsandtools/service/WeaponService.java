package com.devcaiqueoliveira.bweaponsandtools.service;

import com.devcaiqueoliveira.bweaponsandtools.config.WeaponLoader;
import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import com.devcaiqueoliveira.bweaponsandtools.registry.WeaponRegistry;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class WeaponService {

    private final WeaponRegistry weaponRegistry;
    private final WeaponLoader loader;

    public Weapon getWeapon(String name) {
        return weaponRegistry.getWeapon(name.toUpperCase());
    }

    public Set<String> getAvailableWeapons() {
        return weaponRegistry.getAllWeapons();
    }

    public void reloadConfig() {
        loader.load();
    }

}
