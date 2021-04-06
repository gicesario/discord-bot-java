package br.com.dextra.scoremodels.event;

import java.util.function.Consumer;

import discord4j.core.object.entity.Message;
import discord4j.core.spec.EmbedCreateSpec;

public enum TipoComando implements ComandoProcessor {
	HELP {

		@Override
		public Consumer<EmbedCreateSpec> spec(Message mensagem, Consumer<EmbedCreateSpec> embed) {
			return null;
		}
/*
		     Consumer<EmbedCreateSpec> consumer = spec -> {
		    	 spec.setDescription(Color.YELLOW)

		    	 setColor(Color.YELLOW)
		    	 setDescription("HELP!")
					.addField("-help", "exibe todos os comandos disponíveis no bot", false)
					.addField("qow", "Question of the Week!", false);
		     };*/
		}


	/*,

	QOW {
		@Override
		public Mono<Void> executar(Message msg) {

			return null;
		}
	},

	CLIMA {
		@Override
		public Mono<Void> executar(Message msg) {

			return null;
		}
	},

	ADD {

		@Override
		public Mono<Void> executar(Message msg) {
			// TODO Auto-generated method stub
			return null;
		}
	},

	LUPTO {
		// i look up to the

		@Override
		public Mono<Void> executar(Message msg) {
			// TODO Auto-generated method stub
			return null;
		}
	},*/
}
