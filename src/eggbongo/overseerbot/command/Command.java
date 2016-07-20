package eggbongo.overseerbot.command;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public abstract class Command {

    private String key;

    /**
     * Constructor.
     * @param key Keyword used to call the command. ex: 'ping' for command ~ping
     */
    public Command(String key) {
        this.key = key;
    }

    /**
     * Runs before action() - put permission and argument checks here. If the command can't run, put bot's messages here.
     * @param args Array of the arguments passed to the command.
     * @param event The MessageReceivedEvent related to the command.
     * @return Whether or not the command can work.
     */
    public abstract boolean called(String[] args, MessageReceivedEvent event);

    /**
     * Execute the function in here and display output.
     * @param args Array of the arguments passed to the command.
     * @param event The MessageReceivedEvent related to the command.
     */
    public abstract void action(String[] args, MessageReceivedEvent event);

    /**
     * Used by ~help.
     * @return A helpful description of what the function does, and if necessary, usage.
     */
    public abstract String help();


    /**
     * Getter for the function's key.
     * @return The function's key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter for the function's key. Idk when you'd use it but it's there. I guess if you want to mess with user-defined functions?
     * @param key The new key for the function.
     */
    public void setKey(String key) {
        this.key = key;
    }

}
