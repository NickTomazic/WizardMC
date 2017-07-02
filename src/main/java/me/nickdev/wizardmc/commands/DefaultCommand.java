package me.nickdev.wizardmc.commands;

import me.nickdev.wizardmc.Main;
import me.nickdev.wizardmc.chat.CC;
import me.nickdev.wizardmc.chat.O;
import me.nickdev.wizardmc.chat.P;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DefaultCommand implements CommandExecutor {

    private Main main;

    public DefaultCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(CC.SPECIAL + "WizardMC v" + main.getVersion() + CC.NORMAL + " coded by NickDEV. (for Mel's Competition)");
            sender.sendMessage(CC.SPECIAL + "/wizard help " + CC.NORMAL + "- Shows this message");
            sender.sendMessage(CC.SPECIAL + "/wizard gui " + CC.NORMAL + "- Opens the GUI");
            return true;
        }
        if (args.length == 1) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(P.PREFIX.getText() + O.PLAYERS_ONLY.getText());
                return true;
            }
            Player player = (Player) sender;
            if (args[0].equalsIgnoreCase("gui")) {
                if (!(sender.hasPermission("wizard.gui"))) {
                    sender.sendMessage(P.PREFIX.getText() + O.NO_PERMISSION.getText());
                    return true;
                }
                main.getWizardManager().getWizardMenu().open(player);
                return true;
            }
            player.sendMessage(P.PREFIX.getText() + O.WRONG_SYNTAX.getText() + " /wizard help");
            return true;
        }
        return true;
    }
}
