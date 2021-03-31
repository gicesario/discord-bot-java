package br.com.dextra.scoremodels;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.dextra.scoremodels.event.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;

@Configuration
public class Configuracao {

    private final String token = System.getenv().get("token");

    @Bean
    public <T extends Event> GatewayDiscordClient getGatewayDiscord(List<EventListener<T>> eventListeners) {

    	System.out.println("gateway");
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

