package eggbongo.overseerbot.util;

import eggbongo.overseerbot.command.CommandParser;
import eggbongo.overseerbot.Main;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;

import java.util.List;

/**
 * Created by alex on 7/19/16.
 */
public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getMessage().getContent().startsWith(CommandParser.prefix)
                && event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId()) {

            Main.parser.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(),event));

        }

    }

    @Override
    public void onReady(ReadyEvent event) {

        Main.log("status","Logged in as: "+event.getJDA().getSelfInfo().getUsername());

    }

}
