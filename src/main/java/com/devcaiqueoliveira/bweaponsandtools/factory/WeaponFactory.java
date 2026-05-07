package com.devcaiqueoliveira.bweaponsandtools.factory;

import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class WeaponFactory {

    public static ItemStack createWeapon(Weapon weapon) {

        ItemStack itemStack = new ItemStack(weapon.getMaterial());

        itemStack.editMeta(itemMeta -> {
            itemMeta.itemName(weapon.getName());
            itemMeta.lore(weapon.getLore());
        });

        itemStack.editPersistentDataContainer(pdc -> {
            NamespacedKey namespacedKey = new NamespacedKey("bweaponsandtools", "weapon");
            pdc.set(namespacedKey, PersistentDataType.BYTE, (byte) 1);
            pdc.set(namespacedKey, PersistentDataType.DOUBLE, weapon.getDamage());
        });

        return itemStack;

    }
}