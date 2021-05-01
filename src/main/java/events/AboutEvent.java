package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AboutEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("!about")){
            EmbedBuilder about = new EmbedBuilder();
            about.setTitle("Study Hall Bot Information");
            about.setDescription("A bot to help students focus!");
            about.addField("Creators", "A couple UBC 1st year students!", false);
            about.setColor(0xA9927D);

            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(about.build()).queue();
            about.clear();
        }
    }
}