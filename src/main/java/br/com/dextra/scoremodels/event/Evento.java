package br.com.dextra.scoremodels.event;

import org.springframework.stereotype.Service;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

@Service
public class Evento implements ManipuladorEventos<MessageCreateEvent> {

    @Override
    public Class<MessageCreateEvent> getTipoEvento() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> executarComando(MessageCreateEvent evento) {
        return new ProcessaMensagem().processarComandoRecebido(evento.getMessage());
    }
}

