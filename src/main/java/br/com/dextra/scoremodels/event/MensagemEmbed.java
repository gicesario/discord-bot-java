package br.com.dextra.scoremodels.event;

import discord4j.core.spec.EmbedCreateSpec;

@FunctionalInterface
public interface MensagemEmbed {

	public EmbedCreateSpec mensagem();
}
