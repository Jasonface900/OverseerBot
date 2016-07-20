package eggbongo.overseerbot;

import eggbongo.overseerbot.command.CommandParser;
import eggbongo.overseerbot.util.BotListener;
import eggbongo.overseerbot.util.Constants;
import net.dv8tion.jda.JDA;
import net.dv8tion.jda.JDABuilder;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.managers.AccountManager;
import net.dv8tion.jda.utils.AvatarUtil;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.List;

/**
 * Main class for unofficial Overseer discord bot.
 * Written by eggbongo.
 */
public class Main {

    public static JDA jda;

    public static CommandParser parser;

    public static void main(String[] args) {

        try {

            jda = new JDABuilder().addListener(new BotListener()).setBotToken(Constants.token).buildBlocking();
            jda.setAutoReconnect(true);

            jda.getAccountManager().setGame("overseer2.com");

            /*List<Guild> guilds = jda.getGuilds();
            for (int i = 0; i < guilds.size(); i++) {
                guilds.get(i).getPublicChannel().sendMessage("SUP BITCHES. this is ROXY LALONDE aka the unofficial OVERSEERBOT. just warnin u i am here ALIVE N WELL ;3");
            }*/

        } catch(Exception e) {
            e.printStackTrace();
        }

        parser = new CommandParser();

    }

    public static void log(String msgType, String output) {
        String prefix = "";
        switch (msgType) {
            case "status":
                prefix = "[Status] ";
                break;
            case "command":
                prefix = "[Command] ";
                break;
            default:
                break;
        }

        prefix += "[OverseerBot] ";

        System.out.println(prefix + output);
    }

}
