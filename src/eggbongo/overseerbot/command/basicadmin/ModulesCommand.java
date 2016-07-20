package eggbongo.overseerbot.command.basicadmin;

import eggbongo.overseerbot.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public class ModulesCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;

    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return "Lists all available modules. Role 'Botwizard' required for use.";
    }

}
