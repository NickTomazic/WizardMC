package me.nickdev.wizardmc.tools.wand;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.WizardManager;
import me.nickdev.wizardmc.tools.wand.mana.ManaManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class WandManager {

    private HashMap<Element, Wand> wands = new HashMap<>();
    private HashMap<ItemStack, Wand> wandItemStacks = new HashMap<>();
    private ManaManager manaManager;

    public WandManager(Main main, WizardManager wizardManager) {
        loadWands();
        this.manaManager = new ManaManager(main);
        new WandListeners(main, wizardManager);
    }

    private void loadWands() {
        for (Element wandType : Element.values()) {
            try {
                wands.put(wandType, wandType.getWandClass().newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (Wand wand : wands.values()) {
            wandItemStacks.put(wand.getItemStack(), wand);
        }
    }

    public Wand getWand(Element wandType) {
        return wands.get(wandType);
    }

    public ArrayList<Material> getUsedMaterials() {
        ArrayList<Material> usedMaterials = new ArrayList<>();
        for (ItemStack itemStack : wandItemStacks.keySet()) {
            usedMaterials.add(itemStack.getType());
        }
        return usedMaterials;
    }

    public Wand identifyWand(ItemStack itemStack) {
        for (Wand wand : wands.values()) {
            if (!itemStack.hasItemMeta()) return null;
            if (itemStack.getItemMeta().getDisplayName().contains(wand.getItemStack().getItemMeta().getDisplayName())
                    && wand.getItemStack().getType() == itemStack.getType()) {
                return wand;
            }
        }
        return null;
    }

    public ManaManager getManaManager() {
        return manaManager;
    }
}
