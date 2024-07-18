package com.sii.empleados.utilidades;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RestClient {
	
	private final WebClient webClient;

    public RestClient() {
    	this.webClient = WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.codecs(configuracion -> configuracion.defaultCodecs().maxInMemorySize(2*1024*1024*1024))
				.build();
    }
	
	/*public RestClient () {
		this.webClient = WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.codecs(configuracion -> configuracion.defaultCodecs().maxInMemorySize(2*1024*1024*1024))
				.build();
	}*/
	
	public Object consultarEmpleados (String url)  {
		Object respuesta = new Object();
		try {
			respuesta=this.webClient.get().uri(url).retrieve().bodyToMono((new ParameterizedTypeReference<Object>() {
			})).block();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return respuesta;
	}
	

}
