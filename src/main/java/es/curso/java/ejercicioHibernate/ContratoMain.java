package es.curso.java.ejercicioHibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.curso.java.ejercicioHibernate.dao.ContratoDao;
import es.curso.java.ejercicioHibernate.entity.Contrato;
import es.curso.java.hibernate.utils.JpaUtil;
import es.curso.java.utils.Utilidades;
import es.curso.java.utils.UtilsFecha;
import jakarta.persistence.EntityManager;

/**
 * 
 */
public class ContratoMain {

	private final static Date FECHA_INICIO = UtilsFecha.generaFechaActual();

	private static final Logger logger = LogManager.getLogger(ContratoMain.class);

	public static void main(String[] args) {
		ContratoMain cm = new ContratoMain();
		try {
			cm.iniciar();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void iniciar() throws ParseException {

		EntityManager em = JpaUtil.getEM("hibernateOracle");
		ContratoDao contratoDao = new ContratoDao(em);

		// Insertar los contratos
		insertarContratos(contratoDao);
		// Mostrar todos los contratos de la base de datos
		mostrarContratos(contratoDao);
		// Buscar contratos por nombre de cliente
		mostrarPorNombre(contratoDao);
		// Obtener contratos que finalicen después del 10/10/2024
		mostrarFecha(contratoDao);
		// Contratos cuyo importe sea mayor que el valor solicitado
		importeContratos(contratoDao);
	}

	
	
	public void insertarContratos(ContratoDao contratoDao) {

		logger.info("Empieza a insertar los datos");
		
	    List<Contrato> contratos = new ArrayList<>();

	    Date fechaFin1 = UtilsFecha.generaFecha(2023);
	    Date fechaFin2 = UtilsFecha.generaFecha(2024);
	    Date fechaFin3 = UtilsFecha.generaFecha(2025);

	    contratos.add(new Contrato("Nombre1", FECHA_INICIO, fechaFin1, 10000));
	    contratos.add(new Contrato("Nombre2", FECHA_INICIO, fechaFin2, 20000));
	    contratos.add(new Contrato("Nombre3", FECHA_INICIO, fechaFin3, 30000));

	    for (Contrato contrato : contratos) {
	        contratoDao.insertarContratoOracle(contrato);
	        logger.info("Insertando " + contrato);
	    }
	    
	    logger.info("Insertados contactos");
	}
	
	public void mostrarContratos(ContratoDao contratoDao) {
		List<Contrato> contratos = contratoDao.getContratos();
		logger.info("Empieza a mostrar los datos");
		for (Contrato contrato : contratos) {
			logger.info(contrato);
		}
		logger.info("Termina mostrar Contratos");
	}
	
	public void mostrarPorNombre(ContratoDao contratoDao) throws ParseException {

		String nombreSolicitado = Utilidades.pideDatoTexto("Introduzca el nombre a buscar");

		List<Contrato> contratos = contratoDao.getContratosByName(nombreSolicitado);
		logger.info("Nombre solicitado " + nombreSolicitado);
		for (Contrato contrato : contratos) {
			logger.info(contrato);
		}
		logger.info("Termina");
	}
	
	public void mostrarFecha(ContratoDao contratoDao) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String fechaStr = Utilidades.pideDatoTexto("Ingrese la fecha de los contratos a buscar"
				+ " despues de la fecha. Formato dd/MM/yyyy");
		Date fecha = df.parse(fechaStr);

		logger.info("Fecha solicitada " + fecha);
		List<Contrato> contratos = contratoDao.getContratoByDate(fecha);
		for (Contrato contrato : contratos) {
			logger.info(contrato);
		}
		logger.info("Termina");
	}

	public void importeContratos(ContratoDao contratoDao) {
		
		int importeSolicitado = Utilidades.pideDatoNumerico("Introduce importe a buscar (se mostrarán los superiores)");
		
		List<Contrato> contratos = contratoDao.getContratoImporte(importeSolicitado);
		logger.info("Importe solicitado " + importeSolicitado);
		for (Contrato contrato : contratos) {
			logger.info(contrato);
		}
		logger.info("Termina");
	}
		
	
}
