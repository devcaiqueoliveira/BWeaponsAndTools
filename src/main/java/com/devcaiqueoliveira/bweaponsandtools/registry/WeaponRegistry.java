package com.devcaiqueoliveira.bweaponsandtools.registry;

import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;

import java.util.*;

public class WeaponRegistry {

    private final Map<String, Weapon> weapons = new HashMap<>();

    public void add(String name, Weapon weapon) {
        weapons.put(name, weapon);
    }

    public Weapon getWeapon(String name) {
        return weapons.get(name);
    }

    public Set<String> getAllWeapons() {
        return weapons.keySet();
    }

    public void clear() {
        weapons.clear();
    }

}
