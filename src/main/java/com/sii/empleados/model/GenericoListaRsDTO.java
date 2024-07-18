package com.sii.empleados.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericoListaRsDTO<T> extends GenericoRsDTO {
	private List<T> listaDatos;
}
