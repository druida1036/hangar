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
//@IdClass(TareaPK.class)
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private String nombre;

	// bi-directional many-to-one association to PlanMantenimiento
	@ManyToOne()
//	@Id
	@JoinColumn(name = "plan_mantenimiento_id")
	private PlanMantenimiento planMantenimiento;

	// bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy = "tarea")
	private List<DetalleMantenimiento> detalleMantenimientos;

	public Tarea() {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		if (id != other.id)
			return false;
		return true;
	}

}