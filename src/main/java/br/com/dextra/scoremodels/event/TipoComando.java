package br.com.dextra.scoremodels.event;

import discord4j.core.object.entity.Message;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

public enum TipoComando implements ComandoProcessor {
	HELP {

		@Override
		public EmbedCreateSpec spec(Message mensagem) {
			return new EmbedCreateSpec().setAuthor(mensagem.getAuthor().get().getUsername(), mensagem.getAuthor().get().getAvatarUrl(), mensagem.getAuthor().get().getAvatarUrl())
					.setColor(Color.YELLOW)
					.setDescription("HELP!")
					.addField("-help", "exibe todos os comandos disponíveis no bot", false)
					.addField("qow", "Question of the Week!", false);
		}
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
