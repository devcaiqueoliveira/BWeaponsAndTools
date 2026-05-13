package com.devcaiqueoliveira.bweaponsandtools.service;

import com.devcaiqueoliveira.bweaponsandtools.config.WeaponLoader;
import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import com.devcaiqueoliveira.bweaponsandtools.registry.WeaponRegistry;
import lombok.AllArgsConstructor;

import java.util.Set;

public class WeaponService {

    private final WeaponRegistry weaponRegistry;
    private final WeaponLoader loader;

    public WeaponService(WeaponRegistry weaponRegistry, WeaponLoader loader) {
        this.weaponRegistry = weaponRegistry;
        this.loader = loader;
    }

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
