package com.sii.empleados.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericoRsDTO {

	private Boolean exitoso;
	private String tipoError;
	private String descripcionError;
	public Boolean getExitoso() {
		return exitoso;
	}
	public void setExitoso(Boolean exitoso) {
		this.exitoso = exitoso;
	}
	public String getTipoError() {
		return tipoError;
	}
	public void setTipoError(String tipoError) {
		this.tipoError = tipoError;
	}
	public String getDescripcionError() {
		return descripcionError;
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	
	
}
