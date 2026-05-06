package com.devcaiqueoliveira.bweaponsandtools.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Weapon {
    private Component name;
    @Builder.Default
    private List<Component> lore = new ArrayList<>();
    private double damage;
    @Builder.Default
    private Material material = Material.STONE_AXE;
}