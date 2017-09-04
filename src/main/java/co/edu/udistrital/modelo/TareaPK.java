package co.edu.udistrital.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * The primary key class for the tarea database table.
 * 
 */
@Embeddable
public class TareaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	private int planMantenimiento;

	public TareaPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanMantenimiento() {
		return planMantenimiento;
	}
	public void setPlanMantenimiento(int planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + planMantenimiento;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TareaPK other = (TareaPK) obj;
		if (id != other.id)
			return false;
		if (planMantenimiento != other.planMantenimiento)
			return false;
		return true;
	}
}