package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class EarthBuildSpell implements Spell {
    @Override
    public String getName() {
        return "EarthBuild";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Dirt blocks are being placed under you, allowing you to walk on air."
        };
    }

    @Override
    public int getRequiredMana() {
        return 50;
    }

    @Override
    public void activate(Main main, Player player) {
        new BukkitRunnable() {

            private int i = 0;

            @Override
            public void run() {
                if (i > 100) cancel();
                Location location = player.getLocation().add(0, -1, 0);
                if (location.getBlock().getType() == Material.AIR) {
                    location.getBlock().setType(Material.DIRT);

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            location.getBlock().setType(Material.AIR);
                        }
                    }.runTaskLater(main, 20L);
                }
                i++;
            }
        }.runTaskTimer(main, 1L, 1L);
    }
}
