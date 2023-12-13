package es.curso.java.ejercicioSQL;

public class Producto {

	private long id;
	private String nombreProducto;
	private String tipoProducto;
	private double precio;
	private int stock;

	/**
	 * @param id
	 * @param nombreProducto
	 * @param tipoProducto
	 * @param precio
	 * @param stock
	 */
	public Producto(long id, String nombreProducto, String tipoProducto, double precio, int stock) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.tipoProducto = tipoProducto;
		this.precio = precio;
		this.stock = stock;
	}

	/**
	 * @param nombreProducto
	 * @param tipoProducto
	 * @param precio
	 * @param stock
	 */
	public Producto(String nombreProducto, String tipoProducto, double precio, int stock) {
		super();
		this.nombreProducto = nombreProducto;
		this.tipoProducto = tipoProducto;
		this.precio = precio;
		this.stock = stock;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", " + (nombreProducto != null ? "nombreProducto=" + nombreProducto + ", " : "")
				+ (tipoProducto != null ? "tipoProducto=" + tipoProducto + ", " : "") + "precio=" + precio + ", stock="
				+ stock + "]";
	}

}
