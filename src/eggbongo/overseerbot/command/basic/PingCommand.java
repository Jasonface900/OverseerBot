package eggbongo.overseerbot.command.basic;

import eggbongo.overseerbot.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public class PingCommand extends Command {

    public PingCommand() {
        super("ping");
    }

    // this sucker runs no matter what
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("PONG! Your bot is working properly."); // it literally just says pong
    }

    @Override
    public String help() {
        return "A command to check and see if the bot is responding. PONG! :3";
    }


}
