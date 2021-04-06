package br.com.dextra.scoremodels.event;

import java.math.BigInteger;
import java.util.List;

import br.com.dextra.scoremodels.utils.CommandosUtils;
import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProcessaMensagem {

    public Mono<Void> processarComandoRecebido(Message mensagem) {

    	TipoComando cmd = CommandosUtils.getComando(mensagem.getContent().toUpperCase());
    	Flux<Member> g = mensagem.getClient().getGuildMembers(Snowflake.of(new BigInteger("826179915346608221")));

    	List<Member> list1 = g.collectSortedList().block();
    	list1.forEach(System.out::println);

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