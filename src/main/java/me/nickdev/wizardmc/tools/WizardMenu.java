package me.nickdev.wizardmc.tools;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.utils.ItemManager;
import me.nickdev.wizardmc.utils.ListenerComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WizardMenu implements ListenerComponent {

    private WizardManager wizardManager;
    private String inventoryName;
    private Inventory inventory;

    public WizardMenu(Main main, WizardManager wizardManager) {
        this.wizardManager = wizardManager;
        this.inventoryName = "Choose your wizard type!";
        this.inventory = Bukkit.createInventory(null, 27, inventoryName);

        build();
        register(main);
    }

    private void build() {
        inventory.setItem(10, ItemManager.createItem(Material.WOOL, 1, (short) 14, Element.FIRE.getColor() + "FireWizard"));
        inventory.setItem(12, ItemManager.createItem(Material.WOOL, 1, (short) 3, Element.WATER.getColor() + "WaterWizard"));
        inventory.setItem(14, ItemManager.createItem(Material.WOOL, 1, (short) 0, Element.AIR.getColor() + "AirWizard"));
        inventory.setItem(16, ItemManager.createItem(Material.WOOL, 1, (short) 12, Element.EARTH.getColor() + "EarthWizard"));
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        if (clicked == null || clicked.getType() == Material.AIR || !(clicked.hasItemMeta())) return;
        if (!event.getInventory().getName().equals(inventoryName)) return;
        for (Element element : Element.values()) {
            if (clicked.getItemMeta().getDisplayName().toUpperCase().contains(element.toString())) {
                wizardManager.giveClass(player, element);
                break;
            }
        }
        event.setCancelled(true);
        player.closeInventory();
    }
}
