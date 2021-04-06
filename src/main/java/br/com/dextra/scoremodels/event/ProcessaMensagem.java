package br.com.dextra.scoremodels.event;

import discord4j.core.object.entity.Message;
import discord4j.rest.util.Color;
import reactor.core.publisher.Mono;

public class ProcessaMensagem {

	private static final String prefix = "-";

    public Mono<Void> processarComandoRecebido(Message mensagem) {

    	TipoComando cmd = getComando(mensagem.getContent());
    	return Mono.just(mensagem)
	  	          .filter(msg -> msg.getAuthor().map(user -> !user.isBot()).orElse(false))
	  	          .filter(msg -> msg.getContent().equalsIgnoreCase(prefix + cmd.name()))
	  	          .flatMap(Message::getChannel)
	  	          .flatMap(criarMensagem -> criarMensagem.createEmbed(spec -> {
	  	        	spec.setColor(Color.YELLOW)
	  	        	.setDescription("HELP!")
	  	        	.addField("-help", "exibe todos os comandos disponíveis no bot", false)
	  	        	.addField("qow", "Question of the Week!", false);
	  	          })).then();
    }

    private String obterNomeComando(String mensagem) {
    	return mensagem.split(" ")[0];
    }

    private TipoComando getComando(String mensagem) {
    	try {
	    	if (mensagem.startsWith("-") && mensagem.contains(" ")) {
	    		Enum.valueOf(TipoComando.class, obterNomeComando(mensagem));
	    	}
    	}
    	catch (Exception e) {
    		return TipoComando.HELP;
		}

    	return TipoComando.HELP;
    }

}