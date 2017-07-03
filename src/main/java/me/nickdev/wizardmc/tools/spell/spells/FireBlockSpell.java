package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.utils.BlockManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class FireBlockSpell implements Spell {
    @Override
    public String getName() {
        return "FireBlock";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Places a obsidian block, to protect you."
        };
    }

    @Override
    public int getRequiredMana() {
        return 5;
    }

    @Override
    public void activate(Main main, Player player) {
        Block block = BlockManager.getTargetBlock(player, 8).getLocation().add(0, 1, 0).getBlock();
        if (block.getType() == Material.AIR) {
            block.setType(Material.OBSIDIAN);
            new BukkitRunnable() {

                @Override
                public void run() {
                    block.setType(Material.AIR);
                }
            }.runTaskLater(main, 60L);
        }
    }
}
