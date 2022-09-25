package bigman;


import bigman.JDACommands.JDACommands;
import bigman.commands.JoinCommand;
import bigman.commands.PlayCommand;
import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;



import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.EventListener;

public class BotStartUp implements EventListener
{
    // INTENTS is basically what will allow the bot listen for
   public static final GatewayIntent[] INTENTS = {GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_MESSAGES,GatewayIntent.GUILD_MESSAGE_REACTIONS,GatewayIntent.MESSAGE_CONTENT,
                                                    GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_PRESENCES, };

    public static JDA bot;
        public static void main(String[] args) throws LoginException

        {
            JDACommands jdaCommands = new JDACommands("b!g ");
            jdaCommands.registerCommand(new PlayCommand());

            bot = JDABuilder.createDefault("MTAxNjg5NzIzNDkzNzMxNTM3OA.Gz2m-J._fUKFgUDfVJsPi76bcIArc7riN_mYcqA2APK18", Arrays.asList(INTENTS))
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .setActivity(Activity.playing("b!g Splatoon3"))
                    .setStatus(OnlineStatus.ONLINE)
                    .enableCache(CacheFlag.VOICE_STATE)
                    .addEventListeners(new logger())
                    //.addEventListeners(new JoinCommand())
                    //.addEventListeners(new PlayCommand())
                    .build();
        }
}
