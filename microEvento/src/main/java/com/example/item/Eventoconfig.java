package com.example.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class Eventoconfig {

	@Bean
	public RestTemplate regitsroRestTemplate() {
		return new RestTemplate();
	}
}
