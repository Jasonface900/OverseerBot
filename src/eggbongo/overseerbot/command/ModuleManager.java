package eggbongo.overseerbot.command;

import eggbongo.overseerbot.command.basic.HelpCommand;
import eggbongo.overseerbot.command.basic.PingCommand;
import eggbongo.overseerbot.command.crockeros.ToggleCommand;

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
        crockeros.addCommand(new ToggleCommand());
        modules.add(crockeros);

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
