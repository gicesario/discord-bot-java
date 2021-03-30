
package br.com.dextra.scoremodels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class ScoreModelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreModelsApplication.class, args);
	}
}
