package br.com.dextra.scoremodels.utils;

import java.util.List;
import java.util.Optional;

import br.com.dextra.scoremodels.event.TipoComando;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Flux;

public class CommandosUtils {

	private static final String prefix = "-";

	public static String obterNomeComando(String mensagem) {
    	return mensagem.split(" ")[0].trim().replace(prefix, "");
    }

	public static String obterArgumentos(String mensagem, TipoComando cmd) {
    	return mensagem.replace(prefix, "").replace(cmd.name(), "").replace(cmd.name().toLowerCase(), "");
    }

	public static TipoComando getComando(String mensagem) {
    	try {
	    	if (mensagem.startsWith(prefix) && mensagem.contains(" ")) {
	    		return Enum.valueOf(TipoComando.class, obterNomeComando(mensagem));
	    	}
    	}
    	catch (Exception e) {
    		return TipoComando.HELP;
		}

    	return TipoComando.HELP;
    }

    public static Optional<List<Member>> getMembros(Message mensagem) {
    	Flux<Guild> g = mensagem.getClient().getGuilds();

    	List<Guild> listaGuild = g.collectList().block();
    	if (listaGuild.isEmpty()) {
    		return Optional.empty();
    	}
    	return Optional.of(listaGuild.get(0).getMembers().collectSortedList().block());
    }


}

