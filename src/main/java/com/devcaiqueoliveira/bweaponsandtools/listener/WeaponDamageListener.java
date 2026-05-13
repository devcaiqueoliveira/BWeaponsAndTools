package com.devcaiqueoliveira.bweaponsandtools.listener;

import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import com.devcaiqueoliveira.bweaponsandtools.validator.WeaponValidator;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class WeaponDamageListener implements Listener {

    private final WeaponValidator validator;

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) return;

        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();

        if (itemInMainHand.getType() == Material.AIR) return;

        Weapon weapon = validator.getWeapon(itemInMainHand);

        if (weapon == null) return;

        event.setCancelled(true);

        Entity entity = event.getEntity();

        if (entity instanceof LivingEntity target) {
            target.damage(weapon.getDamage(), player);
            player.sendMessage("Voce causou " + weapon.getDamage() + " a esta entidade.");
        }



    }

}
