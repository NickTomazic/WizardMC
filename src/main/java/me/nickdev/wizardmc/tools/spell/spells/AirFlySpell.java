package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.entity.Player;

public class AirFlySpell implements Spell {
    @Override
    public String getName() {
        return "AirFly";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Boosts you in the direction you're looking (spam-clicking allows you to fly)."
        };
    }

    @Override
    public int getRequiredMana() {
        return 5;
    }

    @Override
    public void activate(Main main, Player player) {
        player.setVelocity(player.getLocation().getDirection().multiply(0.5));
    }
}
