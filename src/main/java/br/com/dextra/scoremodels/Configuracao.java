package br.com.dextra.scoremodels;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.dextra.scoremodels.event.ManipuladorEventos;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.gateway.intent.Intent;
import discord4j.gateway.intent.IntentSet;

@Configuration
public class Configuracao {

    private final String token = System.getenv().get("token");

    @Bean
    public <T extends Event> GatewayDiscordClient getGatewayDiscord(List<ManipuladorEventos<T>> eventosRecebidos) {

        IntentSet intentSet = IntentSet.of(Intent.GUILD_MEMBERS);

        GatewayDiscordClient client = DiscordClientBuilder.create(token)
                        .build()
                        .gateway()
                        .setEnabledIntents(intentSet)
                        .login()
                        .block();

        for (ManipuladorEventos<T> evento : eventosRecebidos) {
           client.on(evento.getTipoEvento())
             .flatMap(evento::executarComando)
             .onErrorResume(evento::tratarErros)
             .subscribe();
       }

       client.onDisconnect().block();

       return client;
    }

}

