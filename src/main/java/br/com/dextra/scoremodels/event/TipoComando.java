package br.com.dextra.scoremodels.event;

import java.time.Instant;

import discord4j.core.object.entity.Message;
import discord4j.core.object.reaction.ReactionEmoji;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

public enum TipoComando implements ComandoProcessor {
	HELP {
		@Override
		public void criarEmbed(Message msg, EmbedCreateSpec spec) {
			spec.setColor(Color.YELLOW)
				.setTitle("Score Models | Help:")
			    .addField("-help", "exibe todos os comandos disponíveis no bot", false)
				.addField("-qow", "Question of the Week!", false)
			    .setFooter("", msg.getAuthor().get().getAvatarUrl())
			    .setTimestamp(Instant.now());
			msg.addReaction(ReactionEmoji.unicode("U+1F44D"));
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
