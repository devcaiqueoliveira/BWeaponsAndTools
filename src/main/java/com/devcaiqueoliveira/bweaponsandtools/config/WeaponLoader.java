package com.devcaiqueoliveira.bweaponsandtools.config;

import com.devcaiqueoliveira.bweaponsandtools.model.Weapon;
import com.devcaiqueoliveira.bweaponsandtools.registry.WeaponRegistry;
import lombok.AllArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

@AllArgsConstructor
public class WeaponLoader {

    private final WeaponRegistry registry;
    private final Config config;

    public void load() {

        config.reloadConfig();
        registry.clear();

        ConfigurationSection weaponsSection = config.getConfigurationSection("weapons");


        if (weaponsSection == null) {
            Bukkit.getLogger().info("Sessão é nula");
            return;
        }

        for (String value : weaponsSection.getKeys(false)) {

            ConfigurationSection section = weaponsSection.getConfigurationSection(value);
            if (section == null) continue;
            String name = section.getString("name", "Unknown");
            double damage = section.getDouble("damage");
            String sectionMaterial = section.getString("material", "apple").toUpperCase();
            Material material = Material.getMaterial(sectionMaterial);

            Weapon weapon = Weapon.builder()
                    .name(MiniMessage.miniMessage().deserialize(name))
                    .damage(damage)
                    .material(material)
                    .build();

            registry.add(value.toUpperCase(), weapon);
        }


    }

}
