package br.com.dextra.scoremodels.event;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.dextra.scoremodels.entity.CustomCommand;
import br.com.dextra.scoremodels.repository.CommandRepository;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public abstract class MessageListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CommandRepository commandRepository;


    public Mono<Void> processCommand(Message eventMessage) {
//    	logger.info("Lista de todos os comandos: " + all.size());
        return Mono.just(eventMessage)
          .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
          .filter(message -> message.getContent().equalsIgnoreCase("-ls"))
          .flatMap(Message::getChannel)
          .flatMap(channel -> channel.createMessage("Things to do today:\n - write a bot\n - eat lunch\n - play a game"))
          .then();
    }

    /*

    public Mono<Void> processCommand(Message eventMessage) {

        Optional<User> autorMensagem = eventMessage.getAuthor();
        String comandoDigitado = eventMessage.getContent().toLowerCase();

        if (autorMensagem.isPresent()) {
            User user = autorMensagem.get();
            logger.info("Message Owner ID " + user.getId());
            logger.info("Mention : " + user.getMention());

            if (!user.isBot()) {
                String retornoComandos = "";

                List<CustomCommand> all = commandRepository.findAll();

                logger.info("Lista de todos os comandos: " + all.size());

                if (comandoDigitado.contains("-ls")) {
                    retornoComandos = listarTodosComandos(all);
                }

                /*
                else {
                    int i = comandoDigitado.indexOf(" ");
                    if (i != -1) {
                        Set<String> dbIdentifier = all.stream().map(CustomCommand::getIdentifier).collect(Collectors.toSet());

                        Set<String> collect1 = Arrays.stream(comandoDigitado.split(" ")).collect(Collectors.toSet());
                        for (String c : collect1) {
                            if (dbIdentifier.contains(c.toLowerCase())) {
                                List<CustomCommand> byIdentifierEquals = commandRepository.getByIdentifierEquals(c);
                                CustomCommand customCommand = byIdentifierEquals.get(0);
                                retornoComandos = customCommand.getMessage();
                            }
                        }
                    }
                    else{
                        Set<String> dbIdentifier = all.stream().map(CustomCommand::getIdentifier).collect(Collectors.toSet());
                        for (String s : dbIdentifier) {
                            if (s.contains(comandoDigitado.toLowerCase())) {
                                List<CustomCommand> byIdentifierEquals = commandRepository.getByIdentifierEquals(comandoDigitado.toLowerCase());
                                CustomCommand customCommand = byIdentifierEquals.get(0);
                                retornoComandos = customCommand.getMessage();
                            }
                        }
                    }
                }

                if (retornoComandos.length() != 0) {
                    String finalResp = retornoComandos;
                    logger.error("Embeeded will be executed!!");

                    return eventMessage.getChannel().map(messageChannel -> messageChannel.createEmbed(spec -> spec.setColor(Color.GREEN)
                            .setAuthor("F.A.Q - BOT","","https://www.cookwithmanali.com/wp-content/uploads/2018/04/Vada-Pav.jpg")
                            .setImage("https://www.cookwithmanali.com/wp-content/uploads/2018/04/Vada-Pav.jpg")
                            .setDescription(finalResp)
                            .setTimestamp(Instant.now()))).then();
                }

            }
        }

        return Mono.empty();

    }*/

	private String listarTodosComandos(List<CustomCommand> all) {
		String retornoComandos;
		retornoComandos = all.stream().map(CustomCommand::getComando).collect(Collectors.joining("\n"));
		if (retornoComandos.length()>0) {
		    retornoComandos = "Lista de todos os comandos: \n" + retornoComandos;
		}
		return retornoComandos;
	}

}