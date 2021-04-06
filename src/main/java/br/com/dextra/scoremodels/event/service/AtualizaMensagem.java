package br.com.dextra.scoremodels.event.service;

import org.springframework.stereotype.Service;

import br.com.dextra.scoremodels.event.ManipuladorEventos;
import br.com.dextra.scoremodels.event.ProcessaMensagem;
import discord4j.core.event.domain.message.MessageUpdateEvent;
import reactor.core.publisher.Mono;

@Service
public class AtualizaMensagem implements ManipuladorEventos<MessageUpdateEvent> {

    @Override
    public Class<MessageUpdateEvent> getTipoEvento() {
        return MessageUpdateEvent.class;
    }

    @Override
    public Mono<Void> executarComando(MessageUpdateEvent evento) {
        return Mono.just(evento)
                .filter(MessageUpdateEvent::isContentChanged)
                .flatMap(MessageUpdateEvent::getMessage)
                .flatMap(new ProcessaMensagem()::processarComandoRecebido);
    }
}