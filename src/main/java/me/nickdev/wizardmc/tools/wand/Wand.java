package me.nickdev.wizardmc.tools.wand;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.WizardItem;
import me.nickdev.wizardmc.tools.spell.SpellType;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;

public interface Wand extends WizardItem {
    Element getElement();
    LinkedList<SpellType> getSpells();
    ItemStack getItemStack();
}
