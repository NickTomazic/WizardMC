package me.nickdev.wizardmc.tools.outfit.outfits;

import me.nickdev.wizardmc.tools.outfit.Outfit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class FireOutfit implements Outfit {

    @Override
    public ItemStack getHelmet() {
        return createColoredArmor(Material.LEATHER_HELMET, Color.RED, "AirHelmet");
    }

    @Override
    public ItemStack getChestplate() {
        return createColoredArmor(Material.LEATHER_CHESTPLATE, Color.RED, "AirChestplate");
    }

    @Override
    public ItemStack getLeggings() {
        return createColoredArmor(Material.LEATHER_LEGGINGS, Color.RED, "AirLeggings");
    }

    @Override
    public ItemStack getBoots() {
        return createColoredArmor(Material.LEATHER_BOOTS, Color.RED, "AirBoots");
    }
}
