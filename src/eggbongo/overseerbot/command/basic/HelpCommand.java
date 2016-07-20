package eggbongo.overseerbot.command.basic;

import eggbongo.overseerbot.command.Command;
import eggbongo.overseerbot.command.CommandParser;
import eggbongo.overseerbot.command.Module;
import eggbongo.overseerbot.command.ModuleManager;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public class HelpCommand implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {

        if (args.length > 1) {
            event.getChannel().sendMessage("I don't understand that number of arguments!");
            return false;
        }

        return true;

    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (args.length == 0 || args[0].equals("verbose")) {

            String message = "Use "+CommandParser.prefix+"help [module/command name] for more detailed help.\n**ACTIVE MODULES:**";

            for (int i = 0; i < ModuleManager.modules.size(); i++) {

                Module m = ModuleManager.modules.get(i);
                if (m.enabled) {
                    message += "\n"+
                            m.getName()+"\n"+
                            "*"+m.getDescription()+"*";

                    if (args.length > 0) {

                        for (String c : m.commands.keySet()) {
                            message += "\n"+CommandParser.prefix+c;
                        }

                    }

                }

            }

            event.getChannel().sendMessage(message);

        }

        else {

            for (int i = 0; i < ModuleManager.modules.size(); i++) {

                Module m = ModuleManager.modules.get(i);
                if (m.getName().toLowerCase().equals(args[0].toLowerCase())) {

                    String message = "**"+m.getName()+"**\n"+
                            "Active: *"+m.enabled+"*\n"+
                            m.getDescription() + "\n" +
                            "*Commands:*";

                    for (String command : m.commands.keySet()) {
                        message += "\n"+CommandParser.prefix+command;
                    }

                    event.getChannel().sendMessage(message);

                    return;

                }

            }

            Command command = ModuleManager.getCommand(args[0]);
            if (command != null) {

                String message = "**"+CommandParser.prefix+args[0]+"**\n"+
                        command.help();

                event.getChannel().sendMessage(message);

            } else {
                event.getChannel().sendMessage("Could not find module or command '"+args[0]+"'. Sorry ;-;");
            }

        }

    }

    @Override
    public String help() {
        return "Use this command with a command or module name to learn more about it! `"+ CommandParser.prefix+"help verbose` will give you a very long post describing every module with a list of commands. Tread lightly :3";
    }

}
