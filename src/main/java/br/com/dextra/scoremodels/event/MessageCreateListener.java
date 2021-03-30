package br.com.dextra.scoremodels.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import discord4j.core.event.domain.message.MessageCreateEvent;
import reactor.core.publisher.Mono;

@Service
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public Class<MessageCreateEvent> getEventType() {
        logger.info("Inside Get Event Type");
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        logger.info("Inside execute");
        return processCommand(event.getMessage());
    }
}

