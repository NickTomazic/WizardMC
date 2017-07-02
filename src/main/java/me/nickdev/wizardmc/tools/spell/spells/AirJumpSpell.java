package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class AirJumpSpell implements Spell {
    @Override
    public String getName() {
        return "AirJump";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Boosts you in the direction you're looking really hard."
        };
    }

    @Override
    public int getRequiredMana() {
        return 25;
    }

    @Override
    public void activate(Main main, Player player) {
        player.setVelocity(player.getLocation().getDirection().multiply(1.5));
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1.5f, 1);
        player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 5);
    }
}
