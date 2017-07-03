package me.nickdev.wizardmc.crafting;

import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.outfit.OutfitManager;
import me.nickdev.wizardmc.tools.wand.WandManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class RegisterCrafting {

    private WandManager wandManager;
    private OutfitManager outfitManager;

    public RegisterCrafting(WandManager wandManager, OutfitManager outfitManager) {
        this.wandManager = wandManager;
        this.outfitManager = outfitManager;

        // Wands
        registerWand(Element.FIRE, Material.BLAZE_ROD, Material.BLAZE_POWDER);
        registerWand(Element.WATER, Material.STICK, Material.LAPIS_BLOCK);
        registerWand(Element.AIR, Material.STICK, Material.IRON_BLOCK);
        registerWand(Element.EARTH, Material.STICK, Material.EMERALD_BLOCK);

        // Outfits
        registerOutfitPack(Element.FIRE, Material.BLAZE_POWDER);
        registerOutfitPack(Element.WATER, Material.LAPIS_BLOCK);
        registerOutfitPack(Element.AIR, Material.IRON_BLOCK);
        registerOutfitPack(Element.EARTH, Material.EMERALD_BLOCK);
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

    private void registerOutfitPack(Element element, Material material) {
        ItemStack outfit = outfitManager.getOutfit(element).getOutfitPack();
        ShapedRecipe recipe = new ShapedRecipe(outfit);
        recipe.shape("**",
                    "**");
        recipe.setIngredient('*', material);
        Bukkit.getServer().addRecipe(recipe);
    }
}
