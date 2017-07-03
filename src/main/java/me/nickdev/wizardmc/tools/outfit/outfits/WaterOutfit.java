package me.nickdev.wizardmc.tools.outfit.outfits;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.outfit.Outfit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class WaterOutfit implements Outfit {

    @Override
    public Element getElement() {
        return Element.WATER;
    }

    @Override
    public ItemStack getHelmet() {
        return createEnchantedColoredArmor(Material.LEATHER_HELMET, Color.BLUE, getElement().getColor() + "WaterHelmet", new HashMap<Enchantment, Integer>() {{
            put(Enchantment.OXYGEN, 2);
        }});
    }

    @Override
    public ItemStack getChestplate() {
        return createColoredArmor(Material.LEATHER_CHESTPLATE, Color.BLUE, getElement().getColor() + "WaterChestplate");
    }

    @Override
    public ItemStack getLeggings() {
        return createColoredArmor(Material.LEATHER_LEGGINGS, Color.BLUE, getElement().getColor() + "WaterLeggings");
    }

    @Override
    public ItemStack getBoots() {
        return createColoredArmor(Material.LEATHER_BOOTS, Color.BLUE, getElement().getColor() + "WaterBoots");
    }
}
