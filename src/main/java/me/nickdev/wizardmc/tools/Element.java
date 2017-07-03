package me.nickdev.wizardmc.tools;

import me.nickdev.wizardmc.tools.outfit.Outfit;
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
    FIRE(ChatColor.RED, (short) 14, FireWand.class, FireOutfit.class),
    WATER(ChatColor.BLUE, (short) 3, WaterWand.class, WaterOutfit.class),
    EARTH(ChatColor.GOLD, (short) 12, EarthWand.class, EarthOutfit.class),
    AIR(ChatColor.AQUA, (short) 0, AirWand.class, AirOutfit.class),
    ;

    private ChatColor color;
    private short data;
    private Class<? extends Wand> wandClass;
    private Class<? extends Outfit> outfitClass;

    Element(ChatColor color, short data, Class<? extends Wand> wandClass, Class<? extends Outfit> outfitClass) {
        this.color = color;
        this.data = data;
        this.wandClass = wandClass;
        this.outfitClass = outfitClass;
    }

    public String getFullName() {
        return color + this.toString();
    }

    public String getWizardName() {
        return color + this.toString() + "Wizard";
    }

    public short getData() {
        return data;
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
