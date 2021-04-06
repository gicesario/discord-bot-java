package br.com.dextra.scoremodels.event;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class ProcessaMensagem {

	private static final String prefix = "-";

    public Mono<Void> processarComandoRecebido(Message mensagem) {

    	TipoComando cmd = getComando(mensagem.getContent().toUpperCase());
    	return Mono.just(mensagem)
	  	          .filter(msg -> msg.getAuthor().map(user -> !user.isBot()).orElse(false))
	  	          .filter(msg -> msg.getContent().toUpperCase().contains(cmd.name()))
	  	          .flatMap(Message::getChannel)
	  	          .flatMap(criarMensagem -> criarMensagem.createEmbed(spec -> {
	  	        	cmd.criarEmbed(mensagem, spec);
	  	          }))
	  	          .then();
    }


    private String obterNomeComando(String mensagem) {
    	return mensagem.split(" ")[0];
    }

    private TipoComando getComando(String mensagem) {
    	try {
	    	if (mensagem.trim().startsWith(prefix) && mensagem.contains(" ")) {
	    		return Enum.valueOf(TipoComando.class, obterNomeComando(mensagem));
	    	}
    	}
    	catch (Exception e) {
    		return TipoComando.HELP;
		}

    	return TipoComando.HELP;
    }

}