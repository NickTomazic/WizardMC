package me.nickdev.wizardmc.tools.wand.wands;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.spell.SpellType;
import me.nickdev.wizardmc.tools.wand.Wand;
import me.nickdev.wizardmc.utils.ItemManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.LinkedList;

public class WaterWand implements Wand {
    @Override
    public String getName() {
        return "WaterWand";
    }

    @Override
    public String[] getDescription() {
        return new String[] {
                "waterwand-description"
        };
    }

    @Override
    public Element getElement() {
        return Element.WATER;
    }

    @Override
    public LinkedList<SpellType> getSpells() {
        return new LinkedList<>(Arrays.asList(
                SpellType.FIRECIRCLE,
                SpellType.FIREEXPLOSION,
                SpellType.FIRELIGHTNING,
                SpellType.FIRESHIELD
        ));
    }

    @Override
    public ItemStack getItemStack() {
        return ItemManager.createItem(Material.CARROT_STICK, 1, (short) 0, getElement().getColor() + getName(), getDescription());
    }
}
