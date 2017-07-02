package me.nickdev.wizardmc.tools.wand;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.chat.CC;
import me.nickdev.wizardmc.tools.WizardManager;
import me.nickdev.wizardmc.tools.spell.Spell;
import me.nickdev.wizardmc.tools.spell.SpellType;
import me.nickdev.wizardmc.utils.ListenerComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WandListeners implements ListenerComponent {

    private Main main;
    private WizardManager wizardManager;

    public WandListeners(Main main, WizardManager wizardManager) {
        this.main = main;
        this.wizardManager = wizardManager;

        register(main);
    }

    @EventHandler
    private void onWandUse(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack clicked = event.getItem();
        Action action = event.getAction();
        if (clicked == null || clicked.getType() == Material.AIR || !(wizardManager.getWandManager().getUsedMaterials().contains(clicked.getType()))) return;

        // wand
        Wand wand = wizardManager.getWandManager().identifyWand(clicked);
        String displayName = clicked.getItemMeta().getDisplayName();

        if (wand == null) return;

        // right-click
        if (action == Action.RIGHT_CLICK_BLOCK || action == Action.RIGHT_CLICK_AIR) {
            String spellName = ChatColor.stripColor(clicked.getItemMeta().getDisplayName().replace(wand.getName(), "").replace(" | ", "").replaceAll(" ", "").toUpperCase());
            if (spellName.length() == 0) {
                player.setItemInHand(getWand(wand, wand.getSpells().get(0)));
            } else {
                SpellType currentSpell = SpellType.valueOf(spellName);
                int spellIndex = wand.getSpells().indexOf(currentSpell);
                if (spellIndex >= wand.getSpells().size()-1) {
                    player.setItemInHand(getWand(wand, wand.getSpells().get(0)));
                } else {
                    player.setItemInHand(getWand(wand, wand.getSpells().get(spellIndex+1)));
                }
            }
            return;
        }

        // left-click
        if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK) {
            if (displayName.length() < 15) {
                player.sendMessage(CC.V2 + "Please choose a spell with right-click before activating it!");
                return;
            }
            SpellType spellType = SpellType.valueOf(clicked.getItemMeta().getDisplayName().replace(wand.getItemStack().getItemMeta().getDisplayName() + " | ", "").toUpperCase());
            Spell spell = wizardManager.getSpellManager().getSpell(spellType);
            if (!wizardManager.getWandManager().getManaManager().hasEnoughMana(player, spell)) {
                player.sendMessage(CC.V2 + "You don't have enough mana to activate this spell!");
                return;
            }
            spell.activate(main, player);
            wizardManager.getWandManager().getManaManager().takeMana(player, spell.getRequiredMana());
            player.sendMessage(CC.V1 + "You activated the " + spell.getName().toUpperCase() + ".");
        }
    }

    private ItemStack getWand(Wand wand, SpellType spellType) {
        ItemStack itemStack = wand.getItemStack();
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(wand.getElement().getColor() + wand.getName() + " | " + wizardManager.getSpellManager().getSpell(spellType).getName());
        itemStack.setItemMeta(meta);
        return itemStack;
    }
}
