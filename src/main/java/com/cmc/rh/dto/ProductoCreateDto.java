package com.cmc.rh.dto;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmc.rh.pruebas.ProductoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel( value = "Solicita los datos nesesarios para crear el producto") 
public class ProductoCreateDto {

	
	@Id
	@ApiModelProperty(notes = "ID " )
	private int id;
	@ApiModelProperty(notes = "producto")
	private String producto;
	@ApiModelProperty(notes = "fecha")
	private String fecha;
	@ApiModelProperty(notes = "cantidad")
	private String cantidad;
	@ApiModelProperty(notes = "estado")
	private String estado;
	
	@Autowired
	ProductoEntity paginaPrincipalEntity;
	
	public ProductoCreateDto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "paginaPrincipalCreateDto [id=" + id + ", producto=" + producto + ", fecha=" + fecha + ", cantidad="
				+ cantidad + ", estado=" + estado + "]";
	}

	

	
	
	
}
