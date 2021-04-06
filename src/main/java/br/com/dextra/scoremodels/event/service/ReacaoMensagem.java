package br.com.dextra.scoremodels.event.service;

import br.com.dextra.scoremodels.event.ManipuladorEventos;
import discord4j.core.event.domain.message.ReactionAddEvent;
import reactor.core.publisher.Mono;

public class ReacaoMensagem implements ManipuladorEventos<ReactionAddEvent> {

	 @Override
	 public Class<ReactionAddEvent> getTipoEvento() {
	     return ReactionAddEvent.class;
	 }

	 @Override
	 public Mono<Void> executarComando(ReactionAddEvent evento) {
	     return null; //return new ProcessaMensagem().processarComandoRecebido(evento.getMessage());
	 }

}
