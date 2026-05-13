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
            NamespacedKey isWeaponKey = new NamespacedKey("bweaponsandtools", "is_weapon");
            NamespacedKey damageKey = new NamespacedKey("bweaponsandtools", "weapon_damage");
            NamespacedKey idKey = new NamespacedKey("bweaponsandtools", "weapon_id");

            pdc.set(isWeaponKey, PersistentDataType.BYTE, (byte) 1);
            pdc.set(damageKey, PersistentDataType.DOUBLE, weapon.getDamage());
            pdc.set(idKey, PersistentDataType.STRING, weapon.getId());
        });

        return itemStack;

    }
}