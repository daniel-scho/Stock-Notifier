package com.daniel.stocknotifier.services.messaging;

import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiscordMessagingService extends ListenerAdapter implements MessagingService {

    private JDA jda;

    @Value("${api.discord.token}")
    private String token;

    @PostConstruct
    public void init() {
        System.out.println(token);
        JDABuilder builder = JDABuilder.createDefault(this.token)
                .addEventListeners(new DiscordMessagingService());
        this.jda = builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        var message = event.getMessage().getContentRaw();

        event.getChannel().sendMessage("Hallo, Welt!").queue();
    }

    @Override
    public void sendMessage(String message) {
        TextChannel channel = jda.getTextChannelById("1156902064077676647");
        if (channel != null) {
            channel.sendMessage(message).queue();
        }
    }
}
