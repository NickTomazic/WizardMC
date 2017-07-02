package me.nickdev.wizardmc.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemManager {

    /**
     * Creates an ItemStack.
     * @param material  Material
     * @param amount  Amount
     * @param data  Data
     * @param name  Name
     * @param lore  Lore
     * @return  ItemStack
     */
    public static ItemStack createItem(Material material, int amount, short data, String name, String... lore) {
        ItemStack itemStack = new ItemStack(material, amount, data);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        ArrayList<String> isLore = new ArrayList<>();
        for (String line : lore) isLore.add(ChatColor.GRAY + line);
        itemMeta.setLore(isLore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
