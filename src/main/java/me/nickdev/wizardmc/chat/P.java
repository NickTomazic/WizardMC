package me.nickdev.wizardmc.chat;

import org.bukkit.ChatColor;

public enum P {

    /**
     * Plugin prefix
     */
    PREFIX(ChatColor.RED + "[WizardMC] "),
    PREFIX_NO_COLOR("[WizardMC] "),
    PREFIX_FLAT("WizardMC"),
    ;

    private String text;

    P(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
