package com.devcaiqueoliveira.bweaponsandtools.command;

import com.devcaiqueoliveira.bweaponsandtools.BWeaponsAndToolsPlugin;
import com.devcaiqueoliveira.bweaponsandtools.factory.WeaponFactory;
import com.devcaiqueoliveira.bweaponsandtools.service.WeaponService;
import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import lombok.AllArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class WeaponCommand implements CommandExecutor, TabCompleter {

    private final BWeaponsAndToolsPlugin plugin;
    private final WeaponService weaponService;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;


        switch (args[0]) {
            case "give" -> {
                Weapon weapon = weaponService.getWeapon(args[2]);

                ItemStack itemStack = WeaponFactory.createWeapon(weapon);

                Player target = Bukkit.getPlayer(args[1]);
                if (target == null) {
                    player.sendMessage(Component.text("Este jogador está offline ou não existe."));
                    return false;
                }

                target.getInventory().addItem(itemStack);

                String weaponName = MiniMessage.miniMessage().serialize(weapon.getName());

                target.sendMessage(MiniMessage.miniMessage().deserialize("Enviando " + weaponName + " <white>para o jogador " + player.getName()));
            }
            case "reload" -> {
                weaponService.reloadConfig();
            }
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        List<String> suggestions = new ArrayList<>();
        if (args.length == 1) {
            suggestions.add("give");
        }
        if (args.length == 2) {
            return null;
        }
        if (args.length == 3) {
            for (String weaponName : weaponService.getAvailableWeapons()) {
                if (weaponName.toLowerCase().startsWith(args[2].toLowerCase())) {
                    suggestions.add(weaponName);
                }
            }
        }

        return suggestions;
    }
}
