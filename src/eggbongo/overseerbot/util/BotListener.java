package eggbongo.overseerbot.util;

import eggbongo.overseerbot.Main;
import eggbongo.overseerbot.command.CommandParser;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;
import static eggbongo.overseerbot.command.crockeros.ToggleCommand.*;

/**
 * Created by alex on 7/19/16.
 */
public class BotListener extends ListenerAdapter {

    public static int messagesReceived;

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        // check for commands and send them to the parser
        if (event.getMessage().getContent().startsWith(CommandParser.prefix)
                && event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId()) {

            Main.parser.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(),event));

        }else if(event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId()){
            messagesReceived++;
        }
        while(isToggled && (messagesReceived >= 5)){
            eggbongo.overseerbot.command.crockeros.ToggleCommand.TextRandomizer(event);
            if(messagesReceived >= 5){
                messagesReceived = 0;
            }
        }
    }

    @Override
    public void onReady(ReadyEvent event) {

        // show that the bot is running
        Main.log("status","Logged in as '"+event.getJDA().getSelfInfo().getUsername()+"'");

    }

}
