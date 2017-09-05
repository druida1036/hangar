package co.edu.udistrital.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the detalle_mantenimiento database table.
 * 
 */
@Entity
@Table(name = "detalle_mantenmiento")
@NamedQuery(name = "DetalleMantenimiento.findAll", query = "SELECT d FROM DetalleMantenimiento d")
public class DetalleMantenimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "tipo_mnto")
	private String tipo_mnto;

	private BigDecimal costo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "registro_mantenimiento_id")
	@JsonBackReference
	private RegistroMantenimiento mantenmiento;

	@ManyToOne()
	@JsonManagedReference
	private Tarea tarea;

	@ManyToOne(optional = true)
	@JsonBackReference
	private Componente componente;

	public Componente getComponente() {
		return componente;
	}

	public void setComponente(Componente componente) {
		this.componente = componente;
	}

	public DetalleMantenimiento() {
	}

	public RegistroMantenimiento getMantenmiento() {
		return mantenmiento;
	}

	public void setMantenmiento(RegistroMantenimiento mantenmiento) {
		this.mantenmiento = mantenmiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo_mnto() {
		return tipo_mnto;
	}

	public void setTipo_mnto(String tipo_mnto) {
		this.tipo_mnto = tipo_mnto;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

}