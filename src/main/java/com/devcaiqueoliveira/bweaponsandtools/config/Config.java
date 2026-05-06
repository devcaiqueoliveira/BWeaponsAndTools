package com.devcaiqueoliveira.bweaponsandtools.config;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Config extends YamlConfiguration {
    private final File file;
    private final String name;
    private final JavaPlugin plugin;

    public Config(JavaPlugin plugin, String name) {
        this.plugin = plugin;
        this.name = name;
        this.file = new File(plugin.getDataFolder(), name);

        if (!this.file.exists()) {
            try {
                if (this.file.getParentFile() != null) {
                    this.file.getParentFile().mkdirs();
                }
                this.file.createNewFile();
            } catch (IOException e) {
                this.plugin.getLogger().severe("Não foi possível criar o arquivo dinâmico: " + name);
            }
        }

        this.reloadConfig();
    }

    public void saveConfig() {
        try {
            this.save(this.file);
        } catch (IOException e) {
            this.plugin.getLogger().severe("Erro ao salvar arquivo de configuração: " + this.name);
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        if (this.file.exists()) {
            try {
                this.load(this.file);
            } catch (Exception e) {
                this.plugin.getLogger().severe("Erro ao carregar arquivo de configuração: " + this.name);
            }
        }
    }

}