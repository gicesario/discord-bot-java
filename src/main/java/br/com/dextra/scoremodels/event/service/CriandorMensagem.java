package br.com.dextra.scoremodels.event.service;

import org.springframework.stereotype.Service;

import br.com.dextra.scoremodels.event.GerenciadorMensagens;
import br.com.dextra.scoremodels.event.ManipuladorEventos;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

@Service
public class CriandorMensagem extends GerenciadorMensagens implements ManipuladorEventos<MessageCreateEvent> {


    @Override
    public Class<MessageCreateEvent> getTipoEvento() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> executarComando(MessageCreateEvent evento) {
        return processarComandoRecebido(evento.getMessage());
    }
}

