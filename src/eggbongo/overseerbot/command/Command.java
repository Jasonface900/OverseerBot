package eggbongo.overseerbot.command;

import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public interface Command {

    boolean called(String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event);
    String help();

}
