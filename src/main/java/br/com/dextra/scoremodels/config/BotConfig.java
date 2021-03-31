package br.com.dextra.scoremodels.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.dextra.scoremodels.event.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;


@Configuration
public class BotConfig {

    private String token = "ODI2NDYwNTcyMzM3NzAwOTA0.YGMzYw.4aUrZ2BHXa4Q3ftJlkEGBA-r_U8";

    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {
        GatewayDiscordClient client = null;

        try {
            client = DiscordClientBuilder.create(token)
              .build()
              .login()
              .block();

            for(EventListener<T> listener : eventListeners) {
                client.on(listener.getEventType())
                  .flatMap(listener::execute)
                  .onErrorResume(listener::handleError)
                  .subscribe();
            }
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        return client;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}

