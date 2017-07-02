package me.nickdev.wizardmc.tools.wand.wands;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.spell.SpellType;
import me.nickdev.wizardmc.tools.wand.Wand;
import me.nickdev.wizardmc.utils.ItemManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.LinkedList;

public class AirWand implements Wand {
    @Override
    public String getName() {
        return "AirWand";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "airwand-description"
        };
    }

    @Override
    public Element getElement() {
        return Element.AIR;
    }

    @Override
    public LinkedList<SpellType> getSpells() {
        return new LinkedList<>(Arrays.asList(
                SpellType.AIRJUMP,
                SpellType.AIRFLY
        ));
    }

    @Override
    public ItemStack getItemStack() {
        return ItemManager.createItem(Material.ARROW, 1, (short) 0, getElement().getColor() + getName(), getDescription());
    }
}
