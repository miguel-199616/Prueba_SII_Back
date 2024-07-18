package com.sii.empleados.business;

import com.sii.empleados.model.GenericoDataRsDTO;

public interface IEmpleadosService {
	
	/**
	 * Método encargado de listar los empleados
	 * @param parIdEmpleado id empleado que se envia para hacer filtro
	 * @return lista de empleados obtenida
	 * @author Miguel Angel Hernandez Cubillos
	 */
	public GenericoDataRsDTO<Object> consultarListaEmpleados(String parIdEmpleado) ;

}
