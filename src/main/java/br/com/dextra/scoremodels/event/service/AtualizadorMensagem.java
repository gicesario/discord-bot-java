package br.com.dextra.scoremodels.event.service;

import org.springframework.stereotype.Service;

import br.com.dextra.scoremodels.event.GerenciadorMensagens;
import br.com.dextra.scoremodels.event.ManipuladorEventos;
import discord4j.core.event.domain.message.MessageUpdateEvent;
import reactor.core.publisher.Mono;

@Service
public class AtualizadorMensagem extends GerenciadorMensagens implements ManipuladorEventos<MessageUpdateEvent> {

    @Override
    public Class<MessageUpdateEvent> getTipoEvento() {
        return MessageUpdateEvent.class;
    }

    @Override
    public Mono<Void> executarComando(MessageUpdateEvent evento) {
        return Mono.just(evento)
                .filter(MessageUpdateEvent::isContentChanged)
                .flatMap(MessageUpdateEvent::getMessage)
                .flatMap(super::processarComandoRecebido);
    }
}