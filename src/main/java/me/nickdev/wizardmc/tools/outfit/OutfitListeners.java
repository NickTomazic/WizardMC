package me.nickdev.wizardmc.tools.outfit;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.utils.ListenerComponent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OutfitListeners implements ListenerComponent {

    private Main main;

    public OutfitListeners(Main main) {
        this.main = main;

        register(main);
    }

    @EventHandler
    private void onOutfitInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack clicked = event.getItem();
        Action action = event.getAction();
        if (clicked == null || clicked.getType() == Material.AIR || !clicked.hasItemMeta()) return;
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            Outfit outfit = main.getWizardManager().getOutfitManager().identifyOutfit(clicked);
            if (outfit == null) return;

            player.setItemInHand(null);
            player.getInventory().addItem(outfit.getArmorContents());
            event.setCancelled(true);
        }
    }
}
