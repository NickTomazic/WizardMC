package me.nickdev.wizardmc.tools.outfit.outfits;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.outfit.Outfit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class EarthOutfit implements Outfit {

    @Override
    public Element getElement() {
        return Element.EARTH;
    }

    @Override
    public ItemStack getHelmet() {
        return createColoredArmor(Material.LEATHER_HELMET, Color.NAVY, getElement().getColor() + "EarthHelmet");
    }

    @Override
    public ItemStack getChestplate() {
        return createColoredArmor(Material.LEATHER_CHESTPLATE, Color.NAVY, getElement().getColor() + "EarthChestplate");
    }

    @Override
    public ItemStack getLeggings() {
        return createColoredArmor(Material.LEATHER_LEGGINGS, Color.NAVY, getElement().getColor() + "EarthLeggings");
    }

    @Override
    public ItemStack getBoots() {
        return createEnchantedColoredArmor(Material.LEATHER_BOOTS, Color.NAVY, getElement().getColor() + "EarthBoots", new HashMap<Enchantment, Integer>() {{
            put(Enchantment.PROTECTION_FALL, 3);
        }});
    }
}
