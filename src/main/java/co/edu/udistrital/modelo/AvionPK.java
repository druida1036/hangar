package co.edu.udistrital.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the avion database table.
 * 
 */
@Embeddable
public class AvionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int id;

	@Column(name="nave_id", insertable=false, updatable=false)
	private int naveId;

	public AvionPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNaveId() {
		return this.naveId;
	}
	public void setNaveId(int naveId) {
		this.naveId = naveId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AvionPK)) {
			return false;
		}
		AvionPK castOther = (AvionPK)other;
		return 
			(this.id == castOther.id)
			&& (this.naveId == castOther.naveId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.naveId;
		
		return hash;
	}
}