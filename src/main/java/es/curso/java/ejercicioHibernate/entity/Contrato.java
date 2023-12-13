package es.curso.java.ejercicioHibernate.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CONTRATOS")
public class Contrato {

	@Id
	@SequenceGenerator(name = "CONTRATOSGEN", sequenceName = "CONTRATOS_GEN", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTRATOSGEN")
	@Column(name = "ID")
	private long id;

	@Column(name = "NOMBRE_CLIENTE")
	private String nombreCliente;

	@Column(name = "FECHA_INICIO")
	private Date fechaInicio;

	@Column(name = "FECHA_FIN_CONTRATO")
	private Date fechaFinContrato;

	@Column(name = "IMPORTE")
	private int importe;

	/**
	 * Constructor vacío. Obligado por Hibernate
	 */
	public Contrato() {
		super();
	}

	/**
	 * @param id
	 * @param nombreCliente
	 * @param fechaInicio con un método generado en UtilsFecha que nos devuelve la fecha actual de inicio de contrato
	 * @param fechaFinContrato
	 * @param importe
	 */
	public Contrato(String nombreCliente, Date fechaInicio, Date fechaFinContrato, int importe) {
		super();
		this.nombreCliente = nombreCliente;
		this.fechaInicio = fechaInicio;
		this.fechaFinContrato = fechaFinContrato;
		this.importe = importe;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(Date fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", " + (nombreCliente != null ? "nombreCliente=" + nombreCliente + ", " : "")
				+ (fechaInicio != null ? "fechaInicio=" + fechaInicio + ", " : "")
				+ (fechaFinContrato != null ? "fechaFinContrato=" + fechaFinContrato + ", " : "") + "importe=" + importe
				+ "]";
	}

}
