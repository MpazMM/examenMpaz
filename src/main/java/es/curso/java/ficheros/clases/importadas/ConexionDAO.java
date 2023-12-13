package es.curso.java.ficheros.clases.importadas;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConexionDAO {
	private Connection conexion;

	public ConexionDAO() throws SQLException {
		super();
		this.conexion = UtilsDataBase.getInstance();
	}

	/**
	 * @return the conexion
	 */
	public Connection getConexion() {
		return conexion;
	}
	
	
	
}
