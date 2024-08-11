package com.example.mypkg.Configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * Clase de configuración para crear y configurar un bean de RestTemplate.
 * 
 * @Configuration indica que esta clase contiene definiciones de beans
 * que se deben registrar en el contexto de aplicación de Spring.
 */
@Configuration
public class RestTamplateConfig {
    /**
     * Crea un bean de RestTemplate usando el RestTemplateBuilder.
     * 
     * @param builder Instancia de RestTemplateBuilder utilizada para construir el RestTemplate.
     * @return Un RestTemplate configurado y listo para usar.
     */
	@Bean
	 public RestTemplate restTemplate(RestTemplateBuilder builder){
       return builder.build();	// que se registrará en el contexto de aplicación como un bean.
   }
}