package me.nickdev.wizardmc.commands;

import me.nickdev.wizardmc.Main;

public class RegisterCommands {

    public RegisterCommands(Main main) {
        main.getCommand("wizard").setExecutor(new DefaultCommand(main));
    }
}
