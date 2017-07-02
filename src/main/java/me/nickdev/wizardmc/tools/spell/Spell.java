package me.nickdev.wizardmc.tools.spell;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.WizardItem;
import org.bukkit.entity.Player;

public interface Spell extends WizardItem {
    int getRequiredMana();
    void activate(Main main, Player player);
}
