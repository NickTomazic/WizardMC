package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

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
        List<Entity> near = player.getLocation().getWorld().getEntities();

        System.out.println(near);

        int i = 0;

        for(Entity e : near) {
            if (e == player) {
                System.out.println("is player cancelling");
                continue;
            }
            if(e.getLocation().distance(player.getLocation()) <= radius) {
                e.getLocation().getWorld().strikeLightning(e.getLocation());
                e.getLocation().getWorld().strikeLightning(e.getLocation());
                i++;
            }
        }
        System.out.println(i);
    }
}
