package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.utils.BlockManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class EarthThrowSpell implements Spell {
    @Override
    public String getName() {
        return "EarthThrow";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Throws all the nearby entities in the air."
        };
    }

    @Override
    public int getRequiredMana() {
        return 50;
    }

    @Override
    public void activate(Main main, Player player) {
        double radius = 10D;
        List<Entity> entities = player.getLocation().getWorld().getEntities();
        List<Entity> nearEntites = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity == player || (entity instanceof Item)) continue;
            if (entity.getLocation().distance(player.getLocation()) <= radius) {
                nearEntites.add(entity);
            }
        }
        for (Entity entity : nearEntites) {
            Location up = entity.getLocation().add(0, 10, 0);
            entity.teleport(up);
        }
    }
}
