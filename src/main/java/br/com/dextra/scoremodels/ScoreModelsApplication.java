
package br.com.dextra.scoremodels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource("classpath:beans.xml")
public class ScoreModelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoreModelsApplication.class, args);
	}
}
