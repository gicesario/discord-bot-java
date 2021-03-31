
package br.com.dextra.scoremodels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ScoreModelsApplication {

    @RequestMapping("/")
    @ResponseBody
    String home() {
      return "oi";
    }


	public static void main(String[] args) {
		SpringApplication.run(ScoreModelsApplication.class, args);
	}
}
