package me.nickdev.wizardmc.tools.outfit;

import me.nickdev.wizardmc.utils.ItemManager;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.HashMap;
import java.util.Map;

public interface Outfit {
    ItemStack getHelmet();
    ItemStack getChestplate();
    ItemStack getLeggings();
    ItemStack getBoots();

    default void dressPlayer(Player player) {
        player.getInventory().setArmorContents(
                new ItemStack[] {
                        getBoots(),
                        getLeggings(),
                        getChestplate(),
                        getHelmet(),
                }
        );
    }

    default ItemStack createColoredArmor(Material material, Color color, String name) {
        ItemStack itemStack1 = ItemManager.createItem(material, 1, (short) 0, name);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack1.getItemMeta();
        leatherArmorMeta.setColor(color);
        itemStack1.setItemMeta(leatherArmorMeta);
        itemStack1.addEnchantment(Enchantment.DURABILITY, 2);
        return itemStack1;
    }

    default ItemStack createEnchantedColoredArmor(Material material, Color color, String name, Map<Enchantment, Integer> enchantments) {
        ItemStack itemStack = createColoredArmor(material, color, name);
        itemStack.addEnchantments(enchantments);
        return itemStack;
    }
}
