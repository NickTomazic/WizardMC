package me.nickdev.wizardmc.tools.outfit;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.wand.Wand;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class OutfitManager {

    private HashMap<Element, Outfit> outfits = new HashMap<>();

    public OutfitManager(Main main) {
        loadOutfits();

        new OutfitListeners(main);
    }

    private void loadOutfits() {
        for (Element element : Element.values()) {
            try {
                outfits.put(element, element.getOutfitClass().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public Outfit identifyOutfit(ItemStack itemStack) {
        for (Outfit outfit : outfits.values()) {
            if (!itemStack.hasItemMeta()) return null;
            if (itemStack.getItemMeta().getDisplayName().toLowerCase().contains(outfit.getOutfitPack().getItemMeta().getDisplayName().toLowerCase())
                    && outfit.getOutfitPack().getType() == itemStack.getType()) {
                return outfit;
            }
        }
        return null;
    }

    public Outfit getOutfit(Element element) {
        return outfits.get(element);
    }
}
