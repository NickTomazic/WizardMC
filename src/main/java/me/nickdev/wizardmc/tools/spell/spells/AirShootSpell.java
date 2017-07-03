package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;

public class AirShootSpell implements Spell {
    @Override
    public String getName() {
        return "AirShoot";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Shoots an arrow in the direction you're looking!"
        };
    }

    @Override
    public int getRequiredMana() {
        return 10;
    }

    @Override
    public void activate(Main main, Player player) {
        player.launchProjectile(Arrow.class);
    }
}
