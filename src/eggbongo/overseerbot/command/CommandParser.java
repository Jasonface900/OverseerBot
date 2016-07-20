package eggbongo.overseerbot.command;

import eggbongo.overseerbot.Main;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by alex on 7/19/16.
 */
public class CommandParser {

    public ModuleManager moduleManager;

    public static final String prefix = "~";

    /**
     * Constructor. Sets up hashmap.
     */
    public CommandParser() {
        moduleManager = new ModuleManager();
    }

    /**
     * Handles a command.
     * @param command The CommandContainer produced by parse().
     */
    public void handleCommand(CommandContainer command) {

        Command c = moduleManager.getCommand(command.getInvoke());

        if (c != null) {

            boolean result = c.called(command.getArgs(),command.getE());

            if (result) {
                c.action(command.getArgs(),command.getE());
            }

            Main.log("command","Ran command '"+command.getInvoke()+"' for user '"+command.getE().getAuthor().getUsername()+"' in channel '"+command.getE().getChannel()+"' with "+command.getArgs().length+" arguments.");

        } else {
            command.getE().getTextChannel().sendMessage("Sorry, "+command.getE().getAuthor().getAsMention()+", "+prefix+command.getInvoke()+" is not a command I know yet!");
        }

    }

    /**
     * Parses a raw message into a CommandContainer
     * @param raw The raw message.
     * @param e The event related to the message.
     * @return A command container for the command sent.
     */
    public CommandContainer parse(String raw, MessageReceivedEvent e) {

        String[] split = raw.replaceFirst(prefix,"").split(" ");
        String invoke = split[0];
        String[] args = new String[split.length-1];

        for (int i = 1; i < split.length; i++) {
            args[i-1] = split[i];
        }

        return new CommandContainer(invoke, args, e);

    }

    /**
     * CommandContainer class. Just three variables with getters and setters.
     */
    public class CommandContainer {

        private String invoke;
        private String[] args;
        private MessageReceivedEvent e;

        public CommandContainer(String invoke, String[] args, MessageReceivedEvent e) {
            this.setInvoke(invoke);
            this.setArgs(args);
            this.setE(e);
        }


        public String getInvoke() {
            return invoke;
        }

        public void setInvoke(String invoke) {
            this.invoke = invoke;
        }

        public String[] getArgs() {
            return args;
        }

        public void setArgs(String[] args) {
            this.args = args;
        }

        public MessageReceivedEvent getE() {
            return e;
        }

        public void setE(MessageReceivedEvent e) {
            this.e = e;
        }
    }

}
