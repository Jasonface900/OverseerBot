package eggbongo.overseerbot.command.crockeros;

import eggbongo.overseerbot.command.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import java.util.Random;
import static eggbongo.overseerbot.util.BotListener.messagesReceived;

/**
 * Created by Jorge on 7/20/2016.
 */
public class ToggleCommand extends Command {

    public static boolean isToggled = false;
    public static Random RNGsus = new Random();

    public ToggleCommand() {
        super("toggle");
    }

    @Override
    public boolean called(String[] args, MessageReceivedEvent event){
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event){
        if(isToggled){
            event.getTextChannel().sendMessage("CrockerOS Beta OFF.");
            isToggled = false;
        }else{
            event.getTextChannel().sendMessage("CrockerOS Beta ON.");
            isToggled = true;
        }

        //// TODO: 7/20/2016 make it not break...
    }

    @Override
    public String help() {
        return "A command used to toggle CrockerOS.";
    }

    public static void TextRandomizer(MessageReceivedEvent event){
        switch(RNGsus.nextInt(4)){
            case 0:
                event.getTextChannel().sendMessage("*OBEY*");
                break;
            case 1:
                event.getTextChannel().sendMessage("*CEASE REPRODUCTION*");
                break;
            case 2:
                event.getTextChannel().sendMessage("*STAY ASLEEP*");
                break;
            case 3:
                event.getTextChannel().sendMessage("*CONSUME*");
                break;
            case 4:
                event.getTextChannel().sendMessage("*SUBMIT");
                break;
        }
    }
}
