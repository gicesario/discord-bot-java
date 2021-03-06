package br.com.dextra.scoremodels.event;

import br.com.dextra.scoremodels.utils.CommandosUtils;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class ProcessaMensagem {

    public Mono<Void> processarComandoRecebido(Message mensagem) {

    	TipoComando cmd = CommandosUtils.getComando(mensagem.getContent().toUpperCase());
    	CommandosUtils.getMembros(mensagem).get().forEach(m -> System.out.println("\nMembro " +  m.getDisplayName() + " " + m.toString()));
    	return Mono.just(mensagem)
	  	          .filter(msg -> msg.getAuthor().map(user -> !user.isBot()).orElse(false))
	  	          .filter(msg -> msg.getContent().toUpperCase().contains(cmd.name()))
	  	          .flatMap(Message::getChannel)
	  	          .flatMap(criarMensagem -> criarMensagem.createEmbed(spec -> {
	  	        	cmd.criarEmbed(mensagem, spec, CommandosUtils.obterArgumentos(mensagem.getContent(), cmd));
	  	          }))
	  	          .then();
    }
}