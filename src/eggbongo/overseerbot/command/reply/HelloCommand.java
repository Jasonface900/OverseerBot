package eggbongo.overseerbot.command.reply;

import eggbongo.overseerbot.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by Jorge on 7/21/2016.
 */
public class HelloCommand extends Command{

    public HelloCommand() {
        super("hello");
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        String name = event.getAuthor().getUsername();
        event.getTextChannel().sendMessage("Hello " + name  + "!\nNice to see you!");
    }

    @Override
    public String help() {
        return "A command used to say hello, and get a reply!";
    }

}
