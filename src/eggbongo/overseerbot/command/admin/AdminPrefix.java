package eggbongo.overseerbot.command.admin;

import eggbongo.overseerbot.command.Command;
import net.dv8tion.jda.entities.*;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by Jorge on 7/23/2016.
 */
public class AdminPrefix extends Command{

    public AdminPrefix() {
        super("admin");
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        if(event.getGuild().getRolesForUser(event.getAuthor()).toString().contains("Botwizard")) {
            return true;
        } else{
            event.getChannel().sendMessage("You do not have the proper Role for this command!");
            return false;
        }
    }


    @Override
    public void action(String[] args, MessageReceivedEvent event){
        event.getChannel().sendMessage("Jasonface900 was too LAZY to implement this.");
    }

    @Override
    public String help() {
        return "A prefix used to denote admin specific commands.";
    }

}
