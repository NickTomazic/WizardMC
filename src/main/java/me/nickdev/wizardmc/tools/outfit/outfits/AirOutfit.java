package me.nickdev.wizardmc.tools.outfit.outfits;

import me.nickdev.wizardmc.tools.outfit.Outfit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AirOutfit implements Outfit {

    @Override
    public ItemStack getHelmet() {
        return createColoredArmor(Material.LEATHER_HELMET, Color.WHITE, "AirHelmet");
    }

    @Override
    public ItemStack getChestplate() {
        return createColoredArmor(Material.LEATHER_CHESTPLATE, Color.WHITE, "AirChestplate");
    }

    @Override
    public ItemStack getLeggings() {
        return createColoredArmor(Material.LEATHER_LEGGINGS, Color.WHITE, "AirLeggings");
    }

    @Override
    public ItemStack getBoots() {
        return createEnchantedColoredArmor(Material.LEATHER_BOOTS, Color.WHITE, "AirBoots", new HashMap<Enchantment, Integer>() {{
           put(Enchantment.PROTECTION_FALL, 3);
        }});
    }
}
