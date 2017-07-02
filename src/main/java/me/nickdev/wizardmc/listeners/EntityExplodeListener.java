package me.nickdev.wizardmc.listeners;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.utils.ListenerComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

public class EntityExplodeListener implements ListenerComponent {

    public EntityExplodeListener(Main main) {
        register(main);
    }

    @EventHandler
    public void onExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof TNTPrimed) {
            for (Block block : event.blockList()) {
                final float x = -2.0f + (float)(Math.random() * 5.0);
                final float y = -3.0f + (float)(Math.random() * 7.0);
                final float z = -2.5f + (float)(Math.random() * 6.0);
                final FallingBlock fallingblock = block.getWorld().spawnFallingBlock(block.getLocation(), block.getType(), block.getData());
                fallingblock.setDropItem(false);
                fallingblock.setVelocity(new Vector(x, y, z));
                block.setType(Material.AIR);
            }
        }
    }
}
