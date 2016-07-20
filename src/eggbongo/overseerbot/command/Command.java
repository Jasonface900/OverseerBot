package eggbongo.overseerbot.command;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public interface Command {

    // this function is run first - when creating a command, put your argument number and permission checks here
    boolean called(String[] args, MessageReceivedEvent event);

    // this is for actually executing the command
    void action(String[] args, MessageReceivedEvent event);

    // returns a help string
    String help();

}
