package de.maxprogramm.easyclientcontrol;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyClientControl extends JavaPlugin {

    private static EasyClientControl plugin;

    public static EasyClientControl getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new OnJoin(), this);

        Bukkit.broadcastMessage("ECC has stated up!");

        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.broadcastMessage("ECC has shut down");
    }
}
