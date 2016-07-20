package eggbongo.overseerbot.command;

import java.util.ArrayList;

/**
 * Created by alex on 7/19/16.
 */
public class Module {

    public ArrayList<Command> commands = new ArrayList<>();

    // details of the module
    private String name;
    private String description;
    private boolean required = false;

    // temporary - TODO allow for multiserver use
    public boolean enabled = false;

    /**
     * Constructor
     * @param name Module name.
     * @param description Module description.
     */
    public Module (String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    /**
     * Secondary constructor that allows you to define whether or not the module is required.
     * @param required Whether or not the module is required.
     */
    public Module (String name, String description, boolean required) {
        this(name, description);
        this.setRequired(required);

        enabled = required;
    }

    /**
     * Add a command to the module.
     * @param command The command.
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * Searches for a command in the module.
     * @param key The name of the command.
     * @return The command, if it exists in the module; otherwise null.
     */
    public Command getCommand(String key) {

        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).getKey().equals(key)) return commands.get(i);
        }

        return null;

    }

    // Below here there be GETTERS AND SETTERS. ._.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
