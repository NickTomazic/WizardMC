package me.nickdev.wizardmc.tools.wand.wands;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.spell.SpellType;
import me.nickdev.wizardmc.tools.wand.Wand;
import me.nickdev.wizardmc.utils.ItemManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.LinkedList;

public class FireWand implements Wand {
    @Override
    public String getName() {
        return "FireWand";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "A magical wand for FireWizards!"
        };
    }

    @Override
    public Element getElement() {
        return Element.FIRE;
    }

    @Override
    public LinkedList<SpellType> getSpells() {
        return new LinkedList<>(Arrays.asList(
                SpellType.FIREEXPLOSION,
                SpellType.FIRELIGHTNING,
                SpellType.FIRECREEPER,
                SpellType.FIREBLOCK,

                SpellType.HEAL
        ));
    }

    @Override
    public ItemStack getItemStack() {
        return ItemManager.createItem(Material.BLAZE_ROD, 1, (short) 0, getElement().getColor() + getName(), getDescription());
    }
}
