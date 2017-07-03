package me.nickdev.wizardmc.utils;

import me.nickdev.wizardmc.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BlockIterator;

public class BlockManager {

    public static Block getTargetBlock(Player player, int range) {
        BlockIterator iter = new BlockIterator(player, range);
        Block lastBlock = iter.next();
        while (iter.hasNext()) {
            lastBlock = iter.next();
            if (lastBlock.getType() == Material.AIR) {
                continue;
            }
            break;
        }
        return lastBlock;
    }

    public static void createShield(Main main, Location location, Material material, int revertTicks) {
        location.add(0, 1, 0);
        Block[] blocks = new Block[] {
                location.getBlock(),
                location.add(-1, 0, 0).getBlock(),
                location.add(-1, 0, 0).getBlock(),
                location.add(0, 1, 0).getBlock(),
                location.add(1, 0, 0).getBlock(),
                location.add(1, 0, 0).getBlock(),
                location.add(1, 0, 0).getBlock(),
                location.add(0, -1, 0).getBlock(),
                location.add(0, 2, 0).getBlock(),
                location.add(-1, 0, 0).getBlock(),
                location.add(-1, 0, 0).getBlock(),
                location.add(-1, 0, 0).getBlock(),

                location.add(0, 1, 0).getBlock(),
                location.add(1, 0, 0).getBlock(),
                location.add(0, 1, 0).getBlock(),
                location.add(1, -1, 0).getBlock()
        };
        System.out.println(blocks);

        for (Block block : blocks) {
            System.out.println("ele: " + block);
            block.setType(material);
        }
        new BukkitRunnable() {

            @Override
            public void run() {
                for (Block block : blocks) {
                    block.setType(Material.AIR);
                }
            }
        }.runTaskLater(main, revertTicks);
    }
}
