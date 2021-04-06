package br.com.dextra.scoremodels.event;

import discord4j.core.object.entity.Message;
import discord4j.core.spec.EmbedCreateSpec;

public interface ComandoProcessor {

	public String criarEmbed(Message msg, EmbedCreateSpec spec, String arg);

}
