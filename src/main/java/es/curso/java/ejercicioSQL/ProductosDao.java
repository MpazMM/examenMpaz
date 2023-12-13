package es.curso.java.ejercicioSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProductosDao extends ConexionDAO {

private static final Logger logger = LogManager.getLogger(ProductosDao.class);
	
	public ProductosDao() throws SQLException {
		super();
	}
	
	
	public void insertarProductosBD (Producto producto) 
			throws SQLException{
		insertarProductosBD(producto.getNombreProducto(), producto.getTipoProducto(), producto.getPrecio(), producto.getStock());
	}
	
	
	public void insertarProductosBD (String nombreProducto, String tipoProducto, double precio, int stock) 
			throws SQLException {
	
		logger.debug("Entrando insertarProducto ");

		String query = "INSERT "
				+ "INTO TB_PRODUCTOS (NOMBRE_PRODUCTO,TIPO_PRODUCTO,"
					+ "PRECIO,STOCK) "
				+ "VALUES (?,?,?,?)";
		
		logger.debug(query);
		
		PreparedStatement ps = this.getConexion().prepareStatement(query);
		ps.setString(1, nombreProducto);
		ps.setString(2,tipoProducto);
		ps.setDouble(3, precio);
		ps.setInt(4, stock);
		
		
		int insertados = ps.executeUpdate();
		
		if (insertados==0) {
			logger.warn("No se ha realizado el insert correctamente");
			//throw new NullPointerException("Lo he creado yo");
		}else {
			logger.info("Insert de libro realizado correctamente");
		}
	}
	
	
    public List<Producto> obtenerTodosLosProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        Statement stmt = this.getConexion().createStatement();
		String query = "SELECT ID,NOMBRE_PRODUCTO,TIPO_PRODUCTO,PRECIO,STOCK "
				+ "FROM TB_PRODUCTOS";
		
		ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre_producto");
                String tipo = rs.getString("tipo_producto");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");

                Producto producto = new Producto(id, nombre, tipo, precio, stock);
                productos.add(producto);
            }

        return productos;
    }
    
    public void operacionesProductos() throws SQLException {

        Statement stmt = this.getConexion().createStatement();
		String query = "SELECT tipo_producto, AVG(precio) AS precio_medio, "
				+ "COUNT(*) AS cantidad_productos FROM TB_PRODUCTOS GROUP BY tipo_producto";
		
		 try (ResultSet rs = stmt.executeQuery(query)) {
	            while (rs.next()) {
	                String tipo = rs.getString("tipo_producto");
	                double precioMedio = rs.getDouble("precio_medio");
	                int cantidadProductos = rs.getInt("cantidad_productos");

	                System.out.println("Tipo: " + tipo + ", Precio Medio: " + precioMedio + ", Cantidad de Productos: " + cantidadProductos);
	            }
	        }

    }
}
