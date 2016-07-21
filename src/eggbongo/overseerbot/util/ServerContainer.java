package eggbongo.overseerbot.util;

import eggbongo.overseerbot.command.Module;
import net.dv8tion.jda.entities.Guild;

import java.util.ArrayList;

/**
 * Created by alex on 7/20/16.
 */
public class ServerContainer {

    private Guild server;
    private ArrayList<String> enabledModules = new ArrayList<>();
    private String prefix = "~";
    private boolean logonGreeting = true;

    /**
     * Constructor.
     * @param server The server to store data for.
     */
    public ServerContainer(Guild server) {
        this.server = server;
    }

    // here be GETTERS AND SETTERS .-.

    public Guild getServer() {
        return server;
    }

    public void addModule(Module module) {
        if (!enabledModules.contains(module.getName())) {
            enabledModules.add(module.getName());
        }
    }

    public void removeModule(Module module) {
        if (enabledModules.contains(module.getName())) {
            enabledModules.remove(module.getName());
        }
    }

    public boolean isEnabled(Module module) {
        return enabledModules.contains(module.getName());
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public boolean getLogonGreeting() {
        return logonGreeting;
    }

    public void setLogonGreeting(boolean logonGreeting) {
        this.logonGreeting = logonGreeting;
    }

}
