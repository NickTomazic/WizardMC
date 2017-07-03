package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.utils.BlockManager;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FireLightningSpell implements Spell {
    @Override
    public String getName() {
        return "FireLightning";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Strikes all the entities around you."
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
        if (nearEntites.size() == 0) {
            Location location = BlockManager.getTargetBlock(player, 20).getLocation();
            location.getWorld().strikeLightning(location);
            location.getWorld().strikeLightning(location);
            return;
        }
        for (Entity entity : nearEntites) {
            entity.getLocation().getWorld().strikeLightning(entity.getLocation());
            entity.getLocation().getWorld().strikeLightning(entity.getLocation());
        }
    }
}
