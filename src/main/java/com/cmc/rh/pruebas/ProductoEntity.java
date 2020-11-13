package com.cmc.rh.pruebas;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name ="Producto")
public class ProductoEntity {

@Id
@ApiModelProperty(notes = "id" )
private int id;
@ApiModelProperty(notes = "producto")
private String producto;
@ApiModelProperty(notes = "fecha")
private String fecha;
@ApiModelProperty(notes = "cantidad")
private String cantidad;
@ApiModelProperty(notes = "estado")
private String estado;

public ProductoEntity() {
	// TODO Auto-generated constructor stub
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
	return "ProductoEntity [id=" + id + ", producto=" + producto + ", fecha=" + fecha + ", cantidad=" + cantidad
			+ ", estado=" + estado + "]";
}










}
