package br.com.dextra.scoremodels.event;

import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

public enum TipoComando implements ComandoProcessor {
	HELP {
		@Override
		public void criarEmbed(EmbedCreateSpec spec) {
			spec.setColor(Color.YELLOW)
		    	 .setDescription("Help")
				 .addField("-help", "exibe todos os comandos disponíveis no bot", false)
				 .addField("-qow", "Question of the Week!", false);
			System.out.println(spec);
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
