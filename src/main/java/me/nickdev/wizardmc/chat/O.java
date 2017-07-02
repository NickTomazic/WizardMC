package me.nickdev.wizardmc.chat;

public enum O {

    /**
     * All the message constants used in the plugin.
     */
    PLAYERS_ONLY(CC.V2 +  "This command is for players only."),
    NO_PERMISSION(CC.V2 +  "You don't have the permission to do that."),
    NO_ARGS(CC.V2 +  "Please specify more args. (Player,reason...)"),
    WRONG_SYNTAX(CC.V2 +  "Wrong syntax!"),
    NO_PLAYER(CC.V2 + "Cannot find the statistics."),
    UNKNOWN_ARGUMENTS(CC.V2 + "Unknown arguments."),
    UNKNOWN_COMMAND(CC.V2 + "Unknown command."),
    NO_MONEY(CC.V2 + "You don't have enough money to buy that."),
    NO_PLAYER_DB(CC.V2 + "Cannot find the statistics in the database."),
    FULL_INVENTORY(CC.V2 + "Your manager is full."),
    NO_ITEM(CC.V2 + "You don't have that item."),
    NO_ITEM_ENOUGH(CC.V2 + "You don't have the right amount of that item."),
    ERROR(CC.V2 + "Error occurred."),
    ;

    private String text;

    O(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
