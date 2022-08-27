package com.publicis.creditcard.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;

/**
 * 
 * @author Praveen K
 *
 */
@Configuration
@AllArgsConstructor
public class WebClientConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(WebClientConfiguration.class);
	
	//private final ApplicationProperties properties;

	@Bean("mlWebClient")
	public WebClient webClient() {
		//log.info("Ml App Base Url: {}", properties.getEndpoints().getMlApp().getBaseUrl());
		return WebClient.builder()
				//.baseUrl(properties.getEndpoints().getMlApp().getBaseUrl())
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build();
	}
	
}
