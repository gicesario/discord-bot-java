package br.com.dextra.scoremodels.confg;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.dextra.scoremodels.event.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;

@Configuration
public class BotConfig {

    Logger logger = LoggerFactory.getLogger(this.getClass());
        
    @Value("${token}")
    private String token;

    @Bean
    public GatewayDiscordClient gatewayDiscordClient() {
        return DiscordClientBuilder.create(token)
          .build()
          .login()
          .block();
    }
    
    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {
        GatewayDiscordClient client = DiscordClientBuilder.create(token)
          .build()
          .login()
          .block();

        for(EventListener<T> listener : eventListeners) {
            client.on(listener.getEventType())
              .flatMap(listener::execute)
              .onErrorResume(listener::handleError)
              .subscribe();
        }

        return client;
    }
}
