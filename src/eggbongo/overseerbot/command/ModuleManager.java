package eggbongo.overseerbot.command;

import eggbongo.overseerbot.command.basic.HelpCommand;
import eggbongo.overseerbot.command.basic.PingCommand;

import java.util.ArrayList;

/**
 * Created by alex on 7/19/16.
 */
public class ModuleManager {

    public static ArrayList<Module> modules = new ArrayList<>();

    public ModuleManager() {

        Module basic = new Module("Basic","Basic starter commands.",true);
        basic.addCommand("ping",new PingCommand());
        basic.addCommand("help",new HelpCommand());
        modules.add(basic);

        Module basicadmin = new Module("BasicAdmin","Starter administration commands. These commands require you to have the role 'Botwizard' for use.");
        modules.add(basicadmin);

    }

    public static Command getCommand(String key) {

        for (int i = 0; i < modules.size(); i++) {

            Command c = modules.get(i).getCommand(key);
            if (c != null) return c;

        }

        return null;

    }

}
