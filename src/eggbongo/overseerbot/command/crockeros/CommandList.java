package eggbongo.overseerbot.command.crockeros;

import eggbongo.overseerbot.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import static eggbongo.overseerbot.command.crockeros.ToggleCommand.isToggled;

/**
 * Created by Jorge on 7/21/2016.
 */
public class CommandList extends Command{

    public CommandList() {
        super("cos");
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        if(args.length > 1){
            event.getChannel().sendMessage("Too many arguments!");
            return false;
        }
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        if(args.length == 0){
            event.getChannel().sendMessage("No arguments found!");
        }else if(args[0].equals("toggle")){
            if(isToggled){
                event.getTextChannel().sendMessage("CrockerOS Beta OFF.");
                isToggled = false;
            }else{
                event.getTextChannel().sendMessage("CrockerOS Beta ON.");
                isToggled = true;
            }
        }else{
            event.getChannel().sendMessage("Not a valid argument. Try again :P");
        }
    }

    @Override
    public String help() {
        return "A command to hopefully implement the prefix cos.";
    }
}
