package com.sii.empleados.business.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sii.empleados.business.IEmpleadosService;
import com.sii.empleados.model.GenericoDataRsDTO;
import com.sii.empleados.utilidades.Constantes;
import com.sii.empleados.utilidades.RestClient;

@Service
public class EmpleadosService implements IEmpleadosService {
	
	@Autowired
	private RestClient restClient;
	
	@Value("${data.url.base}")
	private String PATH_BASE;
	
	@Value("${data.url.lista.empleados}")
	private String PATH_LISTA_EMPLEADOS;
	
	@Value("${data.url.empleado.id}")
	private String PATH_EMPLEADO_ID;
	
	@Override
	public GenericoDataRsDTO<Object> consultarListaEmpleados(String parIdEmpleado) {
		
		Object respuestaConsulta = new Object();
		GenericoDataRsDTO<Object> respuesta = new GenericoDataRsDTO<>();
		
		try {
			if(parIdEmpleado.isBlank() && parIdEmpleado.isEmpty()) {
				StringBuilder cadenaUrl = new StringBuilder();
				cadenaUrl.append(PATH_BASE);
				cadenaUrl.append(PATH_LISTA_EMPLEADOS);
				respuestaConsulta = this.restClient.consultarEmpleados(cadenaUrl.toString());								
			}else {
				StringBuilder cadenaUrl = new StringBuilder();
				cadenaUrl.append(PATH_BASE);
				cadenaUrl.append(PATH_EMPLEADO_ID);
				cadenaUrl.append(parIdEmpleado);
				respuestaConsulta = this.restClient.consultarEmpleados(cadenaUrl.toString());
			}				
			respuesta.setData(respuestaConsulta);
			respuesta.setExitoso(Boolean.TRUE);
		} catch (Exception e) {
						
			
			respuesta.setExitoso(Boolean.FALSE);
			respuesta.setTipoError(Constantes.TIPO_ERROR);
			respuesta.setDescripcionError(Constantes.MENSAJE_ERROR_CONSULTA_EMPLEADOS);
		}
		
		
		return respuesta;
	}

}
