package br.com.dextra.scoremodels.utils;

import br.com.dextra.scoremodels.event.TipoComando;

public class CommandosUtils {

	private static final String prefix = "-";

	public static String obterNomeComando(String mensagem) {
    	return mensagem.split(" ")[0].trim().replace(prefix, "");
    }

	public static String obterArgumentos(String mensagem, TipoComando cmd) {
    	return mensagem.replace(prefix, "").replace(cmd.name(), "");
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


}

