package me.nickdev.wizardmc.utils;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public interface ListenerComponent extends Listener {

    /**
     * Registers the listener.
     * @param javaPlugin  JavaPlugin
     */
    default void register(JavaPlugin javaPlugin) {
        Bukkit.getPluginManager().registerEvents(this, javaPlugin);
    }
}
