package com.algonquincollege.s4.cst8276.i18nDBNormalizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ RestController
public class I18nDbNormalizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(I18nDbNormalizerApplication.class, args);
	}

	@GetMapping("hello")
	public String hellow(@RequestParam(value="name",defaultValue="World") String name){
		return String.format("Hello %s !", name);
	}

}
