package eggbongo.overseerbot.command;

import java.util.HashMap;

/**
 * Created by alex on 7/19/16.
 */
public class Module {

    public HashMap<String, Command> commands = new HashMap<>();
    private String name;
    private String description;
    private boolean required = false;

    public boolean enabled = false;

    public Module (String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public Module (String name, String description, boolean required) {
        this(name, description);
        this.setRequired(required);

        enabled = required;
    }

    public void addCommand(String key, Command command) {
        commands.put(key, command);
    }

    public Command getCommand(String key) {
        if (!commands.containsKey(key)) return null;
        return commands.get(key);
    }

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
