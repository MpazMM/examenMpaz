package es.curso.java.hql.producto.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PRODUCTOORACLE")
public class ProductoOracle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column
	private String nombre;

	@Column
	private String tipo;

	@Column
	private Date fechaAlta;

	@Column
	private int precio;

	@Column
	private int unidades;

	/**
	 * 
	 */
	public ProductoOracle() {
		super();
	}

	/**
	 * @param nombre
	 * @param tipo
	 * @param fechaAlta
	 * @param precio
	 * @param unidades
	 */
	public ProductoOracle(String nombre, String tipo, Date fechaAlta, int precio, int unidades) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.precio = precio;
		this.unidades = unidades;
	}

	/**
	 * @param id
	 * @param nombre
	 * @param tipo
	 * @param fechaAlta
	 * @param precio
	 * @param unidades
	 */
	public ProductoOracle(long id, String nombre, String tipo, Date fechaAlta, int precio, int unidades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fechaAlta = fechaAlta;
		this.precio = precio;
		this.unidades = unidades;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "ProductoOracle [id=" + id + ", " + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (tipo != null ? "tipo=" + tipo + ", " : "")
				+ (fechaAlta != null ? "fechaAlta=" + fechaAlta + ", " : "") + "precio=" + precio + ", unidades="
				+ unidades + "]";
	}

}
