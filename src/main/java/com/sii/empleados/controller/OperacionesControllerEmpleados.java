package com.sii.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sii.empleados.business.IEmpleadosService;
import com.sii.empleados.model.GenericoDataRsDTO;
import com.sii.empleados.model.ObjetoString;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE})
@RequestMapping("/empleados")
public class OperacionesControllerEmpleados {
	
	@Autowired
	private IEmpleadosService empleadosService;
	
	@PostMapping("consultar-empleados")
	public ResponseEntity<GenericoDataRsDTO<Object>> consultarEmpleados (@RequestBody ObjetoString parObjeto) {
		GenericoDataRsDTO<Object> resultado = this.empleadosService.consultarListaEmpleados(parObjeto.getMensaje());
		if(resultado.getTipoError() != null) {
			return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<>(resultado, HttpStatus.OK);				
		}
		
	}

}
