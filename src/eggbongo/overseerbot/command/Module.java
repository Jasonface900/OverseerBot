package eggbongo.overseerbot.command;

import java.util.HashMap;

/**
 * Created by alex on 7/19/16.
 */
public class Module {

    //TODO completely redo commands - make the command name be self-contained

    // Hashmap of commands contained within module
    public HashMap<String, Command> commands = new HashMap<>();

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
     * @param key The name of the command.
     * @param command The command.
     */
    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }

    /**
     * Searches for a command in the module.
     * @param key The name of the command.
     * @return The command, if it exists in the module; otherwise null.
     */
    public Command getCommand(String key) {
        if (!commands.containsKey(key)) return null;
        return commands.get(key);
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
