package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HealSpell implements Spell {
    @Override
    public String getName() {
        return "Heal";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Adds regeneration effect."
        };
    }

    @Override
    public int getRequiredMana() {
        return 30;
    }

    @Override
    public void activate(Main main, Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
    }
}
