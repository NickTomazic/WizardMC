package me.nickdev.wizardmc.listeners;

import me.nickdev.wizardmc.Main;

public class RegisterListeners {

    public RegisterListeners(Main main) {
        new EntityExplodeListener(main);
    }
}
