package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.entity.Player;

public class FireShieldSpell implements Spell {
    @Override
    public String getName() {
        return "FireShield";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Creates a shield out of obsidian to protect you."
        };
    }

    @Override
    public int getRequiredMana() {
        return 0;
    }

    @Override
    public void activate(Main main, Player player) {

    }
}
