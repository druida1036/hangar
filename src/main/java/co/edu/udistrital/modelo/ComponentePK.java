package co.edu.udistrital.modelo;

import java.io.Serializable;

/**
 * The primary key class for the componente database table.
 * 
 */
//@Embeddable
public class ComponentePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	

	private int id;

//	@Column(name="nave_id", insertable=false, updatable=false)
	private int nave;

	public ComponentePK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNave() {
		return nave;
	}
	public void setNave(int nave) {
		this.nave = nave;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + nave;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ComponentePK other = (ComponentePK) obj;
		if (id != other.id) {
			return false;
		}
		if (nave != other.nave) {
			return false;
		}
		return true;
	}
	

}