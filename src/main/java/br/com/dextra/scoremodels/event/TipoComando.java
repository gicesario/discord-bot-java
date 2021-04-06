package br.com.dextra.scoremodels.event;

import java.time.Instant;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources;

import discord4j.core.object.entity.Message;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

public enum TipoComando implements ComandoProcessor {
	HELP {
		@Override
		public void criarEmbed(Message msg, EmbedCreateSpec spec) {
			spec.setColor(Color.YELLOW)
				.setTitle("Score Models | Help:")
			    .addField("-help", "exibe todos os comandos disponíveis no bot", false)
				.addField("-qoc", "questão a ser debatida na hora de por café!", false)
				.addField("-lupto", "quem foi o(a) colega ou líder que te inspirou dentro da empresa esse mês?", false)
			    .setFooter("Help", msg.getAuthor().get().getAvatarUrl())
			    .setTimestamp(Instant.now());
		}
	},

	QOC {
		@Override
		public void criarEmbed(Message msg, EmbedCreateSpec spec) {
			spec.setColor(Color.BROWN)
				.setTitle("Score Models | Question da hora do café:")
				.setImage(Resources.class.getResource("img/qoc-logo.png").getPath())
				.setDescription("QOC é uma pergunta semanal a ser debatida na hora do café.")
			    .addField("-qoc", "deixe sua pergunta...", false)
			    .setFooter("Café", msg.getAuthor().get().getAvatarUrl())
			    .setTimestamp(Instant.now());
		}
	},
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

	LUPTO {
		// i look up to the

		@Override
		public Mono<Void> executar(Message msg) {
			// TODO Auto-generated method stub
			return null;
		}
	},*/
}
