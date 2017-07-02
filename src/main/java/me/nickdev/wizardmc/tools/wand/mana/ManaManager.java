package me.nickdev.wizardmc.tools.wand.mana;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.tools.spell.Spell;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ManaManager {

    public ManaManager(Main main) {
        Bukkit.getScheduler().runTaskTimer(main, new ManaRunnable(this), 20L, 20L);
    }

    public void addMana(Player player, int value) {
        player.setLevel(player.getLevel()+value);
    }

    public void takeMana(Player player, int value) {
        player.setLevel(player.getLevel()-value);
    }

    public int getMana(Player player) {
        return player.getLevel();
    }

    public boolean hasEnoughMana(Player player, Spell spell) {
        return getMana(player) >= spell.getRequiredMana();
    }

    public int getMaxMana() {
        return 100;
    }

    public int getMps() {
        return 5;
    }
}
