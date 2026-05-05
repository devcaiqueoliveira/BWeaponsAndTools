package com.devcaiqueoliveira.bweaponsandtools.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.kyori.adventure.text.Component;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Weapon {
    private Component name;
    private List<Component> lore;
    private double damage;
}