package me.nickdev.wizardmc.tools.outfit.outfits;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.outfit.Outfit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class FireOutfit implements Outfit {

    @Override
    public Element getElement() {
        return Element.FIRE;
    }

    @Override
    public ItemStack getHelmet() {
        return createEnchantedColoredArmor(Material.LEATHER_HELMET, Color.RED, getElement().getColor() + "FireHelmet", new HashMap<Enchantment, Integer>() {{
            put(Enchantment.PROTECTION_FIRE, 3);
        }});
    }

    @Override
    public ItemStack getChestplate() {
        return createEnchantedColoredArmor(Material.LEATHER_CHESTPLATE, Color.RED, getElement().getColor() + "FireChestplate", new HashMap<Enchantment, Integer>() {{
            put(Enchantment.PROTECTION_FIRE, 3);
        }});
    }


    @Override
    public ItemStack getLeggings() {
        return createEnchantedColoredArmor(Material.LEATHER_LEGGINGS, Color.RED, getElement().getColor() + "FireLeggings", new HashMap<Enchantment, Integer>() {{
            put(Enchantment.PROTECTION_FIRE, 3);
        }});
    }

    @Override
    public ItemStack getBoots() {
        return createEnchantedColoredArmor(Material.LEATHER_BOOTS, Color.RED, getElement().getColor() + "FireBoots", new HashMap<Enchantment, Integer>() {{
            put(Enchantment.PROTECTION_FIRE, 3);
        }});
    }
}
