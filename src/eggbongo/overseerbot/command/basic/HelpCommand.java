package eggbongo.overseerbot.command.basic;

import eggbongo.overseerbot.command.Command;
import eggbongo.overseerbot.command.CommandParser;
import eggbongo.overseerbot.command.Module;
import eggbongo.overseerbot.command.ModuleManager;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {

        // check for incorrect number of arguments
        if (args.length > 1) {
            event.getChannel().sendMessage("I don't understand that number of arguments!");
            return false;
        }

        return true;

    }

    // Brace urself, this function is long af

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        // if ~help or ~help verbose was called
        if (args.length == 0 || args[0].equals("verbose")) {

            // Opening lines of ~help
            String message = "Use "+CommandParser.prefix+getKey()+" [module/command name] for more detailed help.\n**ACTIVE MODULES:**";

            // Go through all modules and display enabled ones
            for (int i = 0; i < ModuleManager.modules.size(); i++) {

                Module m = ModuleManager.modules.get(i);

                // only display if the module is enabled
                if (m.enabled) {
                    //add row with name and description
                    message += "\n"+
                            m.getName()+"\n"+
                            "*"+m.getDescription()+"*";

                    // if 'verbose' is used then add a list of commands below too
                    if (args.length > 0) {

                        for (Command c : m.commands) {
                            message += "\n"+CommandParser.prefix+c.getKey();
                        }

                    }

                }

            }

            // sEND THAT GIANTASS MESSAGE
            event.getChannel().sendMessage(message);

        }

        else {

            // loop through the modules to look for the command/module
            for (int i = 0; i < ModuleManager.modules.size(); i++) {

                Module m = ModuleManager.modules.get(i);

                // if the module name matches
                if (m.getName().toLowerCase().equals(args[0].toLowerCase())) {

                    // add a row for the module
                    String message = "**"+m.getName()+"**\n"+
                            "Active: *"+m.enabled+"*\n"+
                            m.getDescription() + "\n" +
                            "*Commands:*";

                    // list its commands
                    for (Command command : m.commands) {
                        message += "\n"+CommandParser.prefix+command.getKey();
                    }

                    // send that fuckin message
                    event.getChannel().sendMessage(message);

                    return;

                }

            }

            // if its not ~help verbose or ~help [module name], its gotta be a command. look for it.
            Command command = ModuleManager.getCommand(args[0]);
            if (command != null) {

                // if u found the command describe it
                String message = "**"+CommandParser.prefix+args[0]+"**\n"+
                        command.help();

                event.getChannel().sendMessage(message);

            } else {
                // otherwise ¯\_(ツ)_/¯
                event.getChannel().sendMessage("Could not find module or command '"+args[0]+"'. Sorry ;-;");
            }

        }

    }

    @Override
    public String help() {
        return "Use this command with a command or module name to learn more about it! `"+ CommandParser.prefix+getKey()+" verbose` will give you a very long post describing every module with a list of commands. Tread lightly :3";
    }

}
