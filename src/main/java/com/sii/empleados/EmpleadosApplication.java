package com.sii.empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpleadosApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(EmpleadosApplication.class);
		
	}
	
	@Bean //Esta anotación indica que el método debe producir un bean que se gestionará en el contexto de la aplicación. En este caso el bean es un objeto Webclient.
    WebClient webClient() {
		final int size = 16 * 1024 * 1024; //Se define una variable size que representa el tamaño máximo de la memoria en uso. En este caso, se establece en 16 megabytes. Esto limita la cantidad de memoria utilizada al procesar solicitudes y respuestas.
		final ExchangeStrategies strategies = ExchangeStrategies.builder()// Se crea un objeto ExchangeStrategies.Builder que se utiliza para configurar estrategias de intercambio para el WebClient. Las estrategias de intercambio definen cómo se codifican y decodifican los mensajes en las solicitudes y respuestas HTTP.
				.codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size)).build(); // Se configuran los códecs para el WebClient. En este caso, se establece el tamaño máximo de la memoria en uso usando maxInMemorySize en los códecs predeterminados.  
		return WebClient.builder().exchangeStrategies(strategies).build(); // Construcción del WebClient con las estrategias de intercambio configuradas. Se construye y devuelve una instancia de WebClient utilizando las estrategias de intercambio configuradas.
	}

}
