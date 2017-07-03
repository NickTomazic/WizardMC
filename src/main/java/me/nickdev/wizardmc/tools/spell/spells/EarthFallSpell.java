package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.utils.BlockManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EarthFallSpell implements Spell {
    @Override
    public String getName() {
        return "EarthFall";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Spawns falling dirt above the targeted block."
        };
    }

    @Override
    public int getRequiredMana() {
        return 30;
    }

    @Override
    public void activate(Main main, Player player) {
        Random random = new Random();
        Location targetedLocation = BlockManager.getTargetBlock(player, 10).getLocation().add(0, 10, 0);
        int blocks = random.nextInt(35);
        for (int i = 0; i < blocks; i++) {
            Location newLoc = new Location(targetedLocation.getWorld(), targetedLocation.getX(), targetedLocation.getY(), targetedLocation.getZ());
            newLoc.add(rand(6), rand(3), rand(6));
            newLoc.getWorld().spawnFallingBlock(newLoc, Material.DIRT, (byte) 0);
        }
    }

    private int rand(int max) {
        Random random = new Random();
        int minusPlus = random.nextInt(2);
        int output = random.nextInt(max);
        if (minusPlus == 1) return -output; else return output;
    }
}
