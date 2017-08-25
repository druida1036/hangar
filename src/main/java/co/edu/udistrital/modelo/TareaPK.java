package co.edu.udistrital.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tarea database table.
 * 
 */
@Embeddable
public class TareaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="plan_mantenimiento_id", insertable=false, updatable=false)
	private int planMantenimientoId;

	public TareaPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlanMantenimientoId() {
		return this.planMantenimientoId;
	}
	public void setPlanMantenimientoId(int planMantenimientoId) {
		this.planMantenimientoId = planMantenimientoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TareaPK)) {
			return false;
		}
		TareaPK castOther = (TareaPK)other;
		return 
			(this.id == castOther.id)
			&& (this.planMantenimientoId == castOther.planMantenimientoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.planMantenimientoId;
		
		return hash;
	}
}