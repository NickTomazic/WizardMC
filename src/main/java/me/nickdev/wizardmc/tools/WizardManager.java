package me.nickdev.wizardmc.tools;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.chat.CC;
import me.nickdev.wizardmc.chat.P;
import me.nickdev.wizardmc.tools.outfit.OutfitManager;
import me.nickdev.wizardmc.tools.spell.SpellManager;
import me.nickdev.wizardmc.tools.wand.WandManager;
import me.nickdev.wizardmc.utils.ItemManager;
import me.nickdev.wizardmc.utils.ListenerComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class WizardManager implements ListenerComponent {

    private OutfitManager outfitManager;
    private SpellManager spellManager;
    private WandManager wandManager;
    private WizardMenu wizardMenu;

    public WizardManager(Main main) {
        this.outfitManager = new OutfitManager();
        this.spellManager = new SpellManager();
        this.wandManager = new WandManager(main, this);
        this.wizardMenu = new WizardMenu(main, this);

        register(main);
    }

    public SpellManager getSpellManager() {
        return spellManager;
    }

    public WandManager getWandManager() {
        return wandManager;
    }

    public WizardMenu getWizardMenu() {
        return wizardMenu;
    }

    public OutfitManager getOutfitManager() {
        return outfitManager;
    }

    public void giveClass(Player player, Element element) {
        PlayerInventory pInv = player.getInventory();
        pInv.clear();
        pInv.setItem(0, getWandManager().getWand(element).getItemStack());
        pInv.setItem(7, new ItemStack(Material.COOKED_BEEF, 64));
        pInv.setItem(8, ItemManager.createItem(Material.CHEST, 1, (short) 0, CC.NORMAL + "Change wizardmc type!"));
        getOutfitManager().getOutfit(element).dressPlayer(player);
        sendHelp(player, element);
    }

    private void sendHelp(Player player, Element element) {
        player.sendMessage(P.PREFIX.getText() + CC.NORMAL + "You are now a " + element.getWizardName() + CC.NORMAL + ".");
        player.sendMessage(CC.SPECIAL + "-------(*)- Wand help -(*)-------");
        player.sendMessage(CC.SPECIAL + "right-click " + CC.NORMAL + "- changes the spell");
        player.sendMessage(CC.SPECIAL + "left-click " + CC.NORMAL + "- activates the selected spell");
    }

    @EventHandler
    private void onInteract(PlayerInteractEvent event) {
        ItemStack clicked = event.getItem();
        if (clicked == null || clicked.getType() == null || !(clicked.hasItemMeta())) return;
        if (clicked.getType() == Material.CHEST && clicked.getItemMeta().getDisplayName().equals(CC.NORMAL + "Change wizard type!")) {
            getWizardMenu().open(event.getPlayer());
            event.setCancelled(true);
        }
    }
}
