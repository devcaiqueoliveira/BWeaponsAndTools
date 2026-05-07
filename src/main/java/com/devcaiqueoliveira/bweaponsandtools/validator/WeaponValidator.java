package com.devcaiqueoliveira.bweaponsandtools.validator;

import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class WeaponValidator {

    public boolean validate(ItemStack itemStack) {
        if (itemStack == null) return false;
        NamespacedKey namespacedKey = new NamespacedKey("bweaponsandtools", "weapon");
        return itemStack.getPersistentDataContainer().get(namespacedKey, PersistentDataType.BYTE) == (byte) 1;
    }

}

