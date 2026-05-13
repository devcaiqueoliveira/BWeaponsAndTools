package com.devcaiqueoliveira.bweaponsandtools.validator;

import com.devcaiqueoliveira.bweaponsandtools.factory.WeaponFactory;
import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import com.devcaiqueoliveira.bweaponsandtools.registry.WeaponRegistry;
import lombok.AllArgsConstructor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

@AllArgsConstructor
public class WeaponValidator {

    private final WeaponRegistry registry;

    public boolean isWeapon(ItemStack itemStack) {
        if (itemStack == null) return false;
        NamespacedKey namespacedKey = new NamespacedKey("bweaponsandtools", "is_weapon");
        return itemStack.getPersistentDataContainer().get(namespacedKey, PersistentDataType.BYTE) == (byte) 1;
    }

    public Weapon getWeapon(ItemStack itemStack) {
        NamespacedKey namespacedKey = new NamespacedKey("bweaponsandtools", "weapon_id");
        String weaponId = itemStack.getPersistentDataContainer().get(namespacedKey, PersistentDataType.STRING);
        return registry.getWeapon(weaponId);
    }

}