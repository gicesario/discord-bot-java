package br.com.dextra.scoremodels.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import br.com.dextra.scoremodels.event.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;

@Configuration
public class BotConfig {

    private String token = System.getenv().get("token");


    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {

        GatewayDiscordClient client = DiscordClientBuilder.create(token).build().login().block();

        for (EventListener<T> listener : eventListeners) {
           client.on(listener.getEventType())
             .flatMap(listener::execute)
             .onErrorResume(listener::handleError)
             .subscribe();
       }

       return client;
    }

}

