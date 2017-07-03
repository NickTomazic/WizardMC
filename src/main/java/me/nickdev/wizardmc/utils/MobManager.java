package me.nickdev.wizardmc.utils;

import me.nickdev.wizardmc.Main;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitRunnable;

public class MobManager {

    public static void spawnMob(Main main, Location location, EntityType entityType, String entityName, int despawnTicks) {
        Entity entity = location.getWorld().spawnEntity(location, entityType);
        entity.setCustomNameVisible(true);
        entity.setCustomName(entityName);

        new BukkitRunnable() {

            @Override
            public void run() {
                if (!entity.isDead()) entity.remove();
            }
        }.runTaskLater(main, despawnTicks);
    }

    public static void spawnMob(Main main, Location location, EntityType entityType, String entityName) {
        Entity entity = location.getWorld().spawnEntity(location, entityType);
        entity.setCustomNameVisible(true);
        entity.setCustomName(entityName);
    }
}
