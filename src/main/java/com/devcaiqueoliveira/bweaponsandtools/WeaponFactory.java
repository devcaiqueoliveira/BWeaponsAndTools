package com.devcaiqueoliveira.bweaponsandtools;

import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class WeaponFactory {

    public static ItemStack createWeapon(Weapon weapon) {

        ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);

        itemStack.editMeta(itemMeta -> {
            itemMeta.itemName(weapon.getName());
            itemMeta.lore(weapon.getLore());
        });

        return itemStack;

    }
}