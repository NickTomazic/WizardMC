package me.nickdev.wizardmc.tools.outfit;

import me.nickdev.wizardmc.tools.Element;

import java.util.HashMap;

public class OutfitManager {

    private HashMap<Element, Outfit> outfits = new HashMap<>();

    public OutfitManager() {
        loadOutfits();
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

    public Outfit getOutfit(Element element) {
        return outfits.get(element);
    }
}
