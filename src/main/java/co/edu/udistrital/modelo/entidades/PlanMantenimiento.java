package co.edu.udistrital.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the plan_mantenimiento database table.
 * 
 */
@Entity
@Table(name="plan_mantenimiento")
@NamedQuery(name="PlanMantenimiento.findAll", query="SELECT p FROM PlanMantenimiento p")
public class PlanMantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descripcion;

	private String nombre;

	@Column(name="plan_mantenimientocol")
	private String planMantenimientocol;

	//bi-directional many-to-one association to Tarea
	@OneToMany(mappedBy="planMantenimiento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Tarea> tareas = new ArrayList<>();

	//bi-directional many-to-one association to RegistroMantenmiento
	@OneToMany(mappedBy="planMantenimiento")
	@JsonBackReference
	private List<RegistroMantenimiento> registroMantenmientos = new ArrayList<>();

	public PlanMantenimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public String getPlanMantenimientocol() {
		return this.planMantenimientocol;
	}

	public void setPlanMantenimientocol(String planMantenimientocol) {
		this.planMantenimientocol = planMantenimientocol;
	}

	public List<Tarea> getTareas() {
		return this.tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public Tarea addTarea(Tarea tarea) {
		getTareas().add(tarea);
		tarea.setPlanMantenimiento(this);

		return tarea;
	}

	public Tarea removeTarea(Tarea tarea) {
		getTareas().remove(tarea);
		tarea.setPlanMantenimiento(null);

		return tarea;
	}

	public List<RegistroMantenimiento> getRegistroMantenmientos() {
		return this.registroMantenmientos;
	}

	public void setRegistroMantenmientos(List<RegistroMantenimiento> registroMantenmientos) {
		this.registroMantenmientos = registroMantenmientos;
	}

	public RegistroMantenimiento addRegistroMantenmiento(RegistroMantenimiento registroMantenmiento) {
		getRegistroMantenmientos().add(registroMantenmiento);
		registroMantenmiento.setPlanMantenimiento(this);

		return registroMantenmiento;
	}

	public RegistroMantenimiento removeRegistroMantenmiento(RegistroMantenimiento registroMantenmiento) {
		getRegistroMantenmientos().remove(registroMantenmiento);
		registroMantenmiento.setPlanMantenimiento(null);

		return registroMantenmiento;
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
		PlanMantenimiento other = (PlanMantenimiento) obj;
		if (id != other.id)
			return false;
		return true;
	}

}