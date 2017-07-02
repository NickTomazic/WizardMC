package me.nickdev.wizardmc.tools;

import me.nickdev.wizardmc.tools.outfit.*;
import me.nickdev.wizardmc.tools.outfit.outfits.AirOutfit;
import me.nickdev.wizardmc.tools.outfit.outfits.EarthOutfit;
import me.nickdev.wizardmc.tools.outfit.outfits.FireOutfit;
import me.nickdev.wizardmc.tools.outfit.outfits.WaterOutfit;
import me.nickdev.wizardmc.tools.wand.Wand;
import me.nickdev.wizardmc.tools.wand.wands.AirWand;
import me.nickdev.wizardmc.tools.wand.wands.EarthWand;
import me.nickdev.wizardmc.tools.wand.wands.FireWand;
import me.nickdev.wizardmc.tools.wand.wands.WaterWand;
import org.bukkit.ChatColor;

public enum Element {
    FIRE(ChatColor.RED, FireWand.class, FireOutfit.class),
    WATER(ChatColor.BLUE, WaterWand.class, WaterOutfit.class),
    EARTH(ChatColor.GOLD, EarthWand.class, EarthOutfit.class),
    AIR(ChatColor.AQUA, AirWand.class, AirOutfit.class),
    ;

    private ChatColor color;
    private Class<? extends Wand> wandClass;
    private Class<? extends Outfit> outfitClass;

    Element(ChatColor color, Class<? extends Wand> wandClass, Class<? extends Outfit> outfitClass) {
        this.color = color;
        this.wandClass = wandClass;
        this.outfitClass = outfitClass;
    }

    public String getWizardName() {
        return color + this.toString() + "Wizard";
    }

    public ChatColor getColor() {
        return color;
    }

    public Class<? extends Wand> getWandClass() {
        return wandClass;
    }

    public Class<? extends Outfit> getOutfitClass() {
        return outfitClass;
    }
}
