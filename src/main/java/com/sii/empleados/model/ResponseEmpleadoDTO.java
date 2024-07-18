package com.sii.empleados.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmpleadoDTO {
	private String status;
	private List<EmpleadoDTO> data;
	private String message;
}
