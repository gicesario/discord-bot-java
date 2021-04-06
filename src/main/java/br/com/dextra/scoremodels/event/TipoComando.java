package br.com.dextra.scoremodels.event;

import java.time.Instant;

import discord4j.core.object.entity.Message;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

public enum TipoComando implements ComandoProcessor {
	HELP {
		@Override
		public String criarEmbed(Message msg, EmbedCreateSpec spec, String arg) {
			spec.setColor(Color.YELLOW)
				.setTitle("Score Models | Help:")
			    .addField("-help", "exibe todos os comandos disponíveis no bot", false)
				.addField("-qoc pergunta", "questão a ser debatida na hora de por café!", false)
				.addField("-lupto colega", "quem foi o(a) colega ou líder que te inspirou dentro da empresa esse mês?", false)
			    .setFooter("Help", msg.getAuthor().get().getAvatarUrl())
			    .setTimestamp(Instant.now());
			return arg;
		}
	},

	QOC {
		@Override
		public String criarEmbed(Message msg, EmbedCreateSpec spec, String arg) {
			spec.setColor(Color.BROWN)
				.setTitle("Score Models | Question da hora do café:")
				//.setImage(Resources.class.getResource("img/qoc-logo.png").getPath())
				.setDescription("QOC é uma pergunta semanal a ser debatida na hora do café.")
			    .addField("Sua pergunta", arg, false)
			    .setFooter("Café", msg.getAuthor().get().getAvatarUrl())
			    .setTimestamp(Instant.now());
			return arg;
		}
	},

	LUPTO {
		@Override
		public String criarEmbed(Message msg, EmbedCreateSpec spec, String arg) {

			spec.setColor(Color.BLUE)
			.setTitle("Score Models | Influenciadores:")
			//.setImage(Resources.class.getResource("img/qoc-logo.png").getPath())
			.setDescription("quem foi o(a) colega ou líder que te inspirou dentro da empresa esse mês?")
		    .addField("Sua pergunta", arg, false)
		    .setFooter("Influenciadores", msg.getAuthor().get().getAvatarUrl())
		    .setTimestamp(Instant.now());
			return arg;
		}
		// i look up to the
	}
/*
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

	*/
}
