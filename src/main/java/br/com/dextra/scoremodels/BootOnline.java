package br.com.dextra.scoremodels;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootOnline {

	@GetMapping("/")
	  public String bootOnline() {
        return "Boot ta on";
    }
}
