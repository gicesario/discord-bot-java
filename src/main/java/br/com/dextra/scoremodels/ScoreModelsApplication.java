
package br.com.dextra.scoremodels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.dextra.scoremodels.event.service.PerguntasClimaService;

@SpringBootApplication
public class ScoreModelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreModelsApplication.class, args);
	}
}
