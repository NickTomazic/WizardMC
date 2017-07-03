package me.nickdev.wizardmc;

import me.nickdev.wizardmc.commands.RegisterCommands;
import me.nickdev.wizardmc.crafting.RegisterCrafting;
import me.nickdev.wizardmc.listeners.RegisterListeners;
import me.nickdev.wizardmc.tools.Element;
import me.nickdev.wizardmc.tools.WizardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private PluginDescriptionFile pdf = this.getDescription();
    private String version = pdf.getVersion();

    private WizardManager wizardManager;

    // TODO: add more spells

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[WizardMC] WizardMC v" + version + " has been enabled.");

        // Wizard manager
        wizardManager = new WizardManager(this);

        // Registering everything
        new RegisterCommands(this);
        new RegisterListeners(this);
        new RegisterCrafting(wizardManager.getWandManager(), wizardManager.getOutfitManager());

        Player nickdev = Bukkit.getPlayer("NickDEV");
        nickdev.getInventory().setItem(0, wizardManager.getOutfitManager().getOutfit(Element.FIRE).getOutfitPack());
        nickdev.getInventory().setItem(1, wizardManager.getOutfitManager().getOutfit(Element.WATER).getOutfitPack());
        nickdev.getInventory().setItem(2, wizardManager.getOutfitManager().getOutfit(Element.AIR).getOutfitPack());
        nickdev.getInventory().setItem(3, wizardManager.getOutfitManager().getOutfit(Element.EARTH).getOutfitPack());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[WizardMC] WizardMC v" + version + " has been disabled.");
    }

    public String getVersion() {
        return version;
    }

    public WizardManager getWizardManager() {
        return wizardManager;
    }
}
