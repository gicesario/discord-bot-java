package br.com.dextra.scoremodels.event;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class GerenciadorMensagens {

    public Mono<Void> processarComandoRecebido(Message mensagem) {
    	return Mono.just(mensagem)
          .filter(msg -> msg.getAuthor().map(user -> !user.isBot()).orElse(false))
          .filter(msg -> msg.getContent().equalsIgnoreCase("-ls"))
          .flatMap(Message::getChannel)
          .flatMap(criarMensagem -> criarMensagem.createMessage("Score Models Bot em desenvolvimento..."))
          .then();
    }

}