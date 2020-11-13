package com.cmc.rh.dto;

import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = " Actualiza los datos solicitados del Producto")
public class ProductoUpdateDto {
	


	@ApiModelProperty(notes = "producto")
	private String producto;
	@ApiModelProperty(notes = "fecha")
	private String fecha;
	@ApiModelProperty(notes = "cantidad")
	private String cantidad;
	@ApiModelProperty(notes = "estado")
	private String estado;
	
	public ProductoUpdateDto() {
		
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ProductoUpdateDto [producto=" + producto + ", fecha=" + fecha + ", cantidad=" + cantidad + ", estado="
				+ estado + "]";
	}

	
	
	
	
}
