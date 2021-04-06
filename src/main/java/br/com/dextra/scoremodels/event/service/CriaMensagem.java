package br.com.dextra.scoremodels.event.service;

import br.com.dextra.scoremodels.event.ManipuladorEventos;
import br.com.dextra.scoremodels.event.ProcessaMensagem;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

public class CriaMensagem implements ManipuladorEventos<MessageCreateEvent> {

	 @Override
	 public Class<MessageCreateEvent> getTipoEvento() {
	     return MessageCreateEvent.class;
	 }

	 @Override
	 public Mono<Void> executarComando(MessageCreateEvent evento) {
	     return new ProcessaMensagem().processarComandoRecebido(evento.getMessage());
	 }

}
