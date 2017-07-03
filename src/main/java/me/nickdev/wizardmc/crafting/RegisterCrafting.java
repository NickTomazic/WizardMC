package me.nickdev.wizardmc.crafting;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.wand.WandManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RegisterCrafting {

    private WandManager wandManager;

    public RegisterCrafting(WandManager wandManager) {
        this.wandManager = wandManager;

        registerWand(Element.FIRE, Material.BLAZE_ROD, Material.BLAZE_POWDER);
        registerWand(Element.WATER, Material.STICK, Material.EMERALD_BLOCK);
        registerWand(Element.AIR, Material.STICK, Material.IRON_BLOCK);
        registerWand(Element.EARTH, Material.STICK, Material.GOLD_BLOCK);
    }

    private void registerWand(Element element, Material stick, Material top) {
        ItemStack wand = wandManager.getWand(element).getItemStack();
        ShapedRecipe recipe = new ShapedRecipe(wand);
        recipe.shape("  *",
                    " / ",
                    "/  ");
        recipe.setIngredient('/', stick);
        recipe.setIngredient('*', top);
        Bukkit.getServer().addRecipe(recipe);
    }
}
