package me.nickdev.wizardmc.tools.wand.mana;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ManaRunnable implements Runnable {

    private ManaManager manaManager;

    public ManaRunnable(ManaManager manaManager) {
        this.manaManager = manaManager;
    }

    @Override
    public void run() {
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (all.getLevel() >= manaManager.getMaxMana()) continue;
            manaManager.addMana(all, manaManager.getMps());
        }
    }
}
