package es.curso.java.ejercicioSQL;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ProductoMain {

	private static final Logger logger = LogManager.getLogger(ProductoMain.class);
	
	public static void main(String[] args) {
		
		logger.info("Empezando ProductoMain");
		ProductoMain pm = new ProductoMain();
				try {
					pm.insertarProductos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pm.mostrarProductos();
				
	}
	
	public void mostrarProductos() {
		
		logger.info("Empezando ProductoMain");

        try {
            ProductosDao productosDao = new ProductosDao();
            List<Producto> productos = productosDao.obtenerTodosLosProductos();
            for (Producto producto : productos) {
                System.out.println(producto);
            }

        } catch (SQLException e) {
            logger.error("Error al obtener productos de la base de datos", e);
        }
    }
		
	
	
	public void insertarProductos() throws SQLException{
	    ProductosDao productoDao;  

			productoDao = new ProductosDao();

			productoDao.insertarProductosBD("Producto1", "Alimentacion", 15.99, 14);
			productoDao.insertarProductosBD("Producto4", "Alimentacion", 25.99, 4);
			
	        productoDao.insertarProductosBD("Producto2", "Electronica", 15.90, 6);
	        productoDao.insertarProductosBD("Producto5", "Electronica", 175.90, 8);
	        productoDao.insertarProductosBD("Producto3", "Ropa", 30.99, 2);
	        productoDao.insertarProductosBD("Producto6", "Ropa", 39.99, 2);
	 
	    logger.debug("insertando producto para la tabla ");
	}
	

}
