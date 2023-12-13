package es.curso.java.ddbb.ejercicios.biblioteca.dao;

import java.sql.Connection;
import java.sql.SQLException;

import es.curso.java.ficheros.clases.importadas.UtilsDataBase;

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
