package br.com.dextra.scoremodels.event;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

public interface ManipuladorEventos <T extends Event> {

    Class<T> getTipoEvento();

    Mono<Void> executarComando(T evento);

    default Mono<Void> tratarErros(Throwable erro) {
    	erro.printStackTrace();
        return Mono.empty();
    }
}