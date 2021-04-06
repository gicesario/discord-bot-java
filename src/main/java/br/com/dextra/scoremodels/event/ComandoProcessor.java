package br.com.dextra.scoremodels.event;

import java.util.function.Consumer;

import discord4j.core.object.entity.Message;
import discord4j.core.spec.EmbedCreateSpec;

public interface ComandoProcessor {

	public Consumer<EmbedCreateSpec> spec(Message mensagem, Consumer<EmbedCreateSpec> embed);

}
