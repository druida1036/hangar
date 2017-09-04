package co.edu.udistrital.modelo;

import java.io.Serializable;

/**
 * The primary key class for the detalle_mantenimiento database table.
 * 
 */
public class DetallemantenimientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	

	private int id;

	private int mantenmiento;

	public DetallemantenimientoPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMantenmiento() {
		return mantenmiento;
	}
	public void setMantenmiento(int mantenmiento) {
		this.mantenmiento = mantenmiento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + mantenmiento;
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
		DetallemantenimientoPK other = (DetallemantenimientoPK) obj;
		if (id != other.id)
			return false;
		if (mantenmiento != other.mantenmiento)
			return false;
		return true;
	}
	
	

}