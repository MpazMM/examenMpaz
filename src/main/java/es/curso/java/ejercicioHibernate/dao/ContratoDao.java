package es.curso.java.ejercicioHibernate.dao;

import java.util.Date;
import java.util.List;

import es.curso.java.ejercicioHibernate.entity.Contrato;
import es.curso.java.hibernate.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ContratoDao {

	private EntityManager em;

	public ContratoDao() {
		em = JpaUtil.getEM("hibernateOracle");
	}

	public ContratoDao(String persitenceUnitName) {
		em = JpaUtil.getEM(persitenceUnitName);
	}

	public ContratoDao(EntityManager em) {
		this.em = em;
	}

	public void insertarContratoOracle(Contrato contrato) {
		em.getTransaction().begin();
		try {
			em.persist(contrato);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public List<Contrato> getContratos() {
		List<Contrato> contratos;

		contratos = em.createQuery("from Contrato", Contrato.class).getResultList();

		return contratos;
	}

	public List<Contrato> getContratosByName(String name) {
		List<Contrato> contratos;

		Query query = em.createQuery("from Contrato c where c.nombreCliente=?1", Contrato.class);

		query.setParameter(1, name);
		contratos = query.getResultList();

		return contratos;
	}

	public List<Contrato> getContratoByDate(Date fechaConsulta) {

		Query query = em.createQuery("from Contrato po where po.fechaFinContrato>=?1", Contrato.class);

		query.setParameter(1, fechaConsulta);
		List<Contrato> contratos = query.getResultList();

		return contratos;
	}
	
	public List<Contrato> getContratoImporte(int importeSolicitado) {

		Query query = em.createQuery("from Contrato po where po.importe>=?1", Contrato.class);

		query.setParameter(1, importeSolicitado);
		List<Contrato> contratos = query.getResultList();

		return contratos;
	}

}
