package br.com.dextra.scoremodels.event.service;

import org.springframework.stereotype.Service;

import br.com.dextra.scoremodels.event.EventListener;
import br.com.dextra.scoremodels.event.MessageListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

@Service
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {


    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processCommand(event.getMessage());
    }
}

