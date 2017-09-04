package co.edu.udistrital.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tarea database table.
 * 
 */
@Entity
@NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t")
@IdClass(TareaPK.class)
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TareaPK id;

	private String descripcion;

	private String nombre;

	// bi-directional many-to-one association to PlanMantenimiento
	@ManyToOne
	@JoinColumn(name = "plan_mantenimiento_id", insertable = false, updatable = false)
	private PlanMantenimiento planMantenimiento;

	// bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy = "tarea")
	private List<DetalleMantenimiento> detalleMantenimientos;

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

	public List<DetalleMantenimiento> getDetalleMantenimientos() {
		return detalleMantenimientos;
	}

	public void setDetalleMantenimientos(List<DetalleMantenimiento> detalleMantenimientos) {
		this.detalleMantenimientos = detalleMantenimientos;
	}

}