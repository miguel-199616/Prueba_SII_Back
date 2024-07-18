package com.sii.empleados.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDTO {
	
	private Integer id;
	private String employee_name;
	private BigDecimal employee_salary;
	private BigDecimal employee_salary_year;
	private String profile_image;

}
