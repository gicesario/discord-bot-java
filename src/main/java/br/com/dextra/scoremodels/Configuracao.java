package br.com.dextra.scoremodels;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.dextra.scoremodels.event.ManipuladorEventos;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;

@Configuration
public class Configuracao {

    private final String token = System.getenv().get("token");

    @Bean
    public <T extends Event> GatewayDiscordClient getGatewayDiscord(List<ManipuladorEventos<T>> eventosRecebidos) {

        GatewayDiscordClient client = DiscordClientBuilder.create(token).build().login().block();

        for (ManipuladorEventos<T> evento : eventosRecebidos) {
           client.on(evento.getTipoEvento())
             .flatMap(evento::executarComando)
             .onErrorResume(evento::tratarErros)
             .subscribe();
       }

       return client;
    }

}

