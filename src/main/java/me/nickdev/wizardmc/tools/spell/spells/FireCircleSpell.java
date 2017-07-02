package me.nickdev.wizardmc.tools.spell.spells;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.entity.Player;

public class FireCircleSpell implements Spell {
    @Override
    public String getName() {
        return "FireCircle";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "Creates a deadly spells circle."
        };
    }

    @Override
    public int getRequiredMana() {
        return 0;
    }

    @Override
    public void activate(Main main, Player player) {
        player.sendMessage("cirkulac");
    }
}
