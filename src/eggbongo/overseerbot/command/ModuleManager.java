package eggbongo.overseerbot.command;

import eggbongo.overseerbot.command.admin.AdminPrefix;
import eggbongo.overseerbot.command.basic.HelpCommand;
import eggbongo.overseerbot.command.basic.PingCommand;
import eggbongo.overseerbot.command.crockeros.CommandList;
import eggbongo.overseerbot.command.crockeros.ToggleCommand;
import eggbongo.overseerbot.command.reply.GoodbyeCommand;
import eggbongo.overseerbot.command.reply.HelloCommand;

import java.util.ArrayList;

/**
 * Created by alex on 7/19/16.
 */
public class ModuleManager {

    // list of available modules
    public static ArrayList<Module> modules = new ArrayList<>();

    /**
     * Constructor
     */
    public ModuleManager() {

        // initialize basic module
        Module basic = new Module("Basic","Basic starter commands.",true);
        basic.addCommand(new PingCommand());
        basic.addCommand(new HelpCommand());
        modules.add(basic);

        // initialize basicadmin module
        Module basicadmin = new Module("BasicAdmin","Starter administration commands. These commands require you to have the role 'Botwizard' for use.",true);
        modules.add(basicadmin);

        // initialize crockeros module
        Module crockeros = new Module("CrockerOS","The defacto version of Betty Crocker's Operating System.", true);
        crockeros.addCommand(new CommandList());
        crockeros.addCommand(new ToggleCommand());
        modules.add(crockeros);

        // intitialize hello module
        Module reply = new Module("Reply","Replies to things?", true);
        reply.addCommand(new HelloCommand());
        reply.addCommand(new GoodbyeCommand());
        modules.add(reply);

        // initialize admin module
        Module admin = new Module("Admin","Have access to admin commands.", true);
        admin.addCommand(new AdminPrefix());
        modules.add(admin);


    }

    /**
     * Searches for a command in available modules.
     * @param key The name of the command.
     * @return The command.
     */
    public static Command getCommand(String key) {

        for (int i = 0; i < modules.size(); i++) {

            //TODO check for inactive modules

            Command c = modules.get(i).getCommand(key);
            if (c != null) return c;

        }

        return null;

    }

}
