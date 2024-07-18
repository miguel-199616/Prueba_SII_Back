package com.sii.empleados.business.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sii.empleados.model.GenericoDataRsDTO;
import com.sii.empleados.utilidades.Constantes;
import com.sii.empleados.utilidades.RestClient;

public class EmpleadosServiceTest {
	
	@InjectMocks
	private EmpleadosService empleadosService;
	
	@Mock
	private RestClient restClient;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	public EmpleadosServiceTest () {
	
	}
	
	@Test
	public void consultarListaEmpleadosConIdEmpleado()  {
		String idEmpleado = "1";
		GenericoDataRsDTO<Object> respuesta = new GenericoDataRsDTO<>();
		respuesta.setExitoso(Boolean.TRUE);
		Object objetoRespuesta = new Object();
		when(restClient.consultarEmpleados(idEmpleado)).thenReturn(objetoRespuesta);
		assertEquals(respuesta.getExitoso(), empleadosService.consultarListaEmpleados(idEmpleado).getExitoso());
	}
	
	@Test
	public void consultarListaEmpleadosSinIdEmpleado() {
		String idEmpleado = "";
		GenericoDataRsDTO<Object> respuesta = new GenericoDataRsDTO<>();
		respuesta.setExitoso(Boolean.TRUE);
		Object objetoRespuesta = new Object();
		when(restClient.consultarEmpleados(idEmpleado)).thenReturn(objetoRespuesta);
		assertEquals(respuesta.getExitoso(), empleadosService.consultarListaEmpleados(idEmpleado).getExitoso());
	}
	
	@Test
	public void consultarListaEmpleadosConError() {
		String idEmpleado = "";
		GenericoDataRsDTO<Object> respuesta = new GenericoDataRsDTO<>();
		respuesta.setExitoso(Boolean.FALSE);
		respuesta.setTipoError(Constantes.TIPO_ERROR);
		respuesta.setDescripcionError(Constantes.MENSAJE_ERROR_CONSULTA_EMPLEADOS);
		Object objetoRespuesta = new Object();
		when(restClient.consultarEmpleados(idEmpleado)).thenReturn(objetoRespuesta);
		assertEquals(respuesta, empleadosService.consultarListaEmpleados(idEmpleado));
	}
	

}
