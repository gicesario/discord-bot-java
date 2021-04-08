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
			    .addField("-help", "Exibe todos os comandos disponiveis no bot", false)
				.addField("-ask pergunta", "O que debater na hora do cafe?", false)
				.addField("-clima ?", "Qual a pergunta do dia?", false)
				.addField("-clima S|N", "Respona a pergunta de clima", false)
				.addField("-lupto colega", "Quem te inspirou dentro da squad esse mes?", false)
			    .setFooter("Help", msg.getAuthor().get().getAvatarUrl())
			    .setTimestamp(Instant.now());
			return arg;
		}
	},

	ASK {
		@Override
		public String criarEmbed(Message msg, EmbedCreateSpec spec, String arg) {
			spec.setColor(Color.BROWN)
				.setTitle("Score Models | Question da hora do cafe:")
				//.setImage(Resources.class.getResource("img/qoc-logo.png").getPath())
				.setDescription("O que debater na hora do cafe?")
			    .addField("Sua sugestao:", arg, false)
			    .setFooter("Cafe", msg.getAuthor().get().getAvatarUrl())
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
			.setDescription("Quem te inspirou dentro da squad alem do Inuy?")
		    .addField("Escolhido:", arg, false)
		    .setFooter("Influenciadores", msg.getAuthor().get().getAvatarUrl())
		    .setTimestamp(Instant.now());
			return arg;
		}
		// i look up to the
	},

	CLIMA {
		@Override
		public String criarEmbed(Message msg, EmbedCreateSpec spec, String arg) {
			spec.setColor(Color.GREEN)
			.setTitle("Score Models | Pergunta de Clima:")
			.setDescription("Pergunta do dia:")
			.addField(getFieldNome(arg), getFieldValor(arg), false)
		    .setFooter("Clima: ", msg.getAuthor().get().getAvatarUrl())
		    .setTimestamp(Instant.now());
			return arg;
		}

		private String getFieldNome(String arg) {
			if (arg.trim().equals("?")) {
				return "A squad tem metas alinhadas aos objetivos pessoas/profissionais?";
			}
			return "Digite -clima ? para ver a pergunta do dia";
		}

		private String getFieldValor(String arg) {
			if (arg.trim().equalsIgnoreCase("S") || arg.trim().equalsIgnoreCase("N")) {
				return arg;
			}

			return "Resposta invalida";
		}

	},
/*
	ADD {

		@Override
		public Mono<Void> executar(Message msg) {
			// TODO Auto-generated method stub
			return null;
		}
	},

	*/
}
