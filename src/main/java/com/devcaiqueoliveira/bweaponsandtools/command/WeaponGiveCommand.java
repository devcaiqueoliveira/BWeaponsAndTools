package com.devcaiqueoliveira.bweaponsandtools.command;

import com.devcaiqueoliveira.bweaponsandtools.BWeaponsAndToolsPlugin;
import com.devcaiqueoliveira.bweaponsandtools.WeaponFactory;
import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import lombok.AllArgsConstructor;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class WeaponGiveCommand implements CommandExecutor, TabCompleter {

    private final BWeaponsAndToolsPlugin plugin;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) return false;

        if (args[0].equalsIgnoreCase("give")) {

            Weapon weapon = Weapon.builder()
                    .name(Component.text("<yellow>ESPADA SUPER OP"))
                    .lore(List.of(Component.text("<red>Nem cavalo guenta")))
                    .damage(50)
                    .build();

            ItemStack itemStack = WeaponFactory.createWeapon(weapon);

            player.getInventory().addItem(itemStack);
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
            ConfigurationSection weaponsSection = plugin.getConfig().getConfigurationSection("weapons");

            if (weaponsSection != null) {
                for (String weaponName : weaponsSection.getKeys(false)) {
                    if (weaponName.toLowerCase().startsWith(args[2].toLowerCase())) {
                        suggestions.add(weaponName);
                    }
                }
            }
        }

        return suggestions;
    }
}
