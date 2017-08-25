package co.edu.udistrital.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarea database table.
 * 
 */
@Entity
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TareaPK id;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to PlanMantenimiento
	@ManyToOne
	@JoinColumn(name="plan_mantenimiento_id")
	private PlanMantenimiento planMantenimiento;

	public Tarea() {
	}

	public TareaPK getId() {
		return this.id;
	}

	public void setId(TareaPK id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PlanMantenimiento getPlanMantenimiento() {
		return this.planMantenimiento;
	}

	public void setPlanMantenimiento(PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}

}