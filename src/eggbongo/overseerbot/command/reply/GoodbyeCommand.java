package eggbongo.overseerbot.command.reply;

import eggbongo.overseerbot.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static eggbongo.overseerbot.Main.jda;

/**
 * Created by Jorge on 7/21/2016.
 */
public class GoodbyeCommand extends Command{
    public GoodbyeCommand() {
        super("goodbye");
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        String name = event.getAuthor().getUsername();
        event.getTextChannel().sendMessage("Goodbye " + name  + "!\nShutting down...");
        jda.shutdown();
    }

    @Override
    public String help() {
        return "A command used to say goodbye, and shut me down.\n*Please don't do this :(*";
    }

}
