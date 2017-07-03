package me.nickdev.wizardmc.tools.outfit.outfits;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.outfit.Outfit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class AirOutfit implements Outfit {

    @Override
    public Element getElement() {
        return Element.AIR;
    }

    @Override
    public ItemStack getHelmet() {
        return createColoredArmor(Material.LEATHER_HELMET, Color.WHITE, getElement().getColor() + "AirHelmet");
    }

    @Override
    public ItemStack getChestplate() {
        return createColoredArmor(Material.LEATHER_CHESTPLATE, Color.WHITE, getElement().getColor() + "AirChestplate");
    }

    @Override
    public ItemStack getLeggings() {
        return createColoredArmor(Material.LEATHER_LEGGINGS, Color.WHITE, getElement().getColor() + "AirLeggings");
    }

    @Override
    public ItemStack getBoots() {
        return createEnchantedColoredArmor(Material.LEATHER_BOOTS, Color.WHITE, getElement().getColor() + "AirBoots", new HashMap<Enchantment, Integer>() {{
           put(Enchantment.PROTECTION_FALL, 3);
        }});
    }
}
