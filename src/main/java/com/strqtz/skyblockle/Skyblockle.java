package com.strqtz.skyblockle;

import com.strqtz.skyblockle.commands.*;
import com.strqtz.skyblockle.events.AOTEEvent;
import com.strqtz.skyblockle.events.RogueEvent;
import com.strqtz.skyblockle.items.ItemManager;
import com.strqtz.skyblockle.utils.GUIEH;
import com.strqtz.skyblockle.utils.IGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Skyblockle extends JavaPlugin implements Listener {

    private File customConfigFile;
    public FileConfiguration customConfig;
    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable() {
        createCustomConfig();
        customConfig.addDefault("item.aspectOfTheEnd", true);
        customConfig.addDefault("item.rogueSword", true);
        ItemManager.aoteinit();
        ItemManager.rogueSwordinit();
        getServer().getPluginManager().registerEvents(new AOTEEvent(), this);
        getServer().getPluginManager().registerEvents(new RogueEvent(), this);
        getServer().getPluginManager().registerEvents(new GUIEH(), this);
        getCommand("giveaote").setExecutor(new GiveAoteCommand());
        getCommand("giverogue").setExecutor(new GiveRogueCommand());
        getCommand("sbgive").setExecutor(new SkyblockGiveCommand());
        console.sendMessage(ChatColor.GREEN + "Skyblockle" + " " + ChatColor.BLUE + "Enabled");
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        console.sendMessage(ChatColor.GREEN + "Skyblockle" + " " + ChatColor.RED + "Disabled");
    }
}
