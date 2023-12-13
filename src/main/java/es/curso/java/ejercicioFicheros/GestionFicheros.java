package es.curso.java.ejercicioFicheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class GestionFicheros {
	private static final Logger logger = LogManager.getLogger(GestionFicheros.class);
	private String RUTA_FICHERO = "./ficheros/FicheroEjercicio2.txt";
	private int contadorJavas;

	public static void main(String[] args) {
		GestionFicheros gestionFicheros = new GestionFicheros();
		try {
			gestionFicheros.leerFichero();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public String leerFichero() throws IOException {
		logger.info(RUTA_FICHERO);
    	Path path = Paths.get(RUTA_FICHERO);
		StringBuilder sb = new StringBuilder();

		List<String> lines = Files.readAllLines(path);
		for (String linea : lines) {
			sb.append(linea+"\n");
			logger.info(linea);
		}

		return sb.toString();
    }
	
	

}