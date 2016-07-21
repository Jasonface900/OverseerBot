package eggbongo.overseerbot;

import eggbongo.overseerbot.command.CommandParser;
import eggbongo.overseerbot.util.BotListener;
import eggbongo.overseerbot.util.Constants;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.entities.Guild;

import java.util.List;

/**
 * Main class for unofficial Overseer discord bot.
 * Written by eggbongo.
 */
public class Main {

    // public variables
    public static JDA jda;
    public static CommandParser parser;

    public static void main(String[] args) {

        try {

            // initialize JDA
            jda = new JDABuilder().addListener(new BotListener()).setBotToken(Constants.token).buildBlocking();
            jda.setAutoReconnect(true);

            // cosmetic stuff
            jda.getAccountManager().setGame("overseer2.com");

            // compile list of guilds the bot is in
            List<Guild> guilds = jda.getGuilds();
            for (int i = 0; i < guilds.size(); i++) {

                log("status","Logged into server '"+guilds.get(i).getName()+"'"); //log servers

                // notify server that bot is online - with style ;3
                guilds.get(i).getPublicChannel().sendMessage("waddup bitches its ROXY LALONDE aka the unofficial OVERSEERBOT. coming to you ALIVE AND WELL ;3");

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        // initialize command parser
        parser = new CommandParser();

    }

    // for command line log - currently two types of log
    public static void log(String msgType, String output) {

        String prefix = "";

        // TODO add timestamp to log

        switch (msgType) { // add prefix if message is known type
            case "status":
                prefix = "[Status] ";
                break;
            case "command":
                prefix = "[Command] ";
                break;
            default:
                break;
        }

        prefix += "[OverseerBot] "; // add bot name to log for the hell of it

        System.out.println(prefix + output); // spit out line into log

    }

}
