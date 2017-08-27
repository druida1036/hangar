package co.edu.udistrital.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the avion database table.
 * 
 */
@Entity
@NamedQuery(name="Avion.findAll", query="SELECT a FROM Avion a")
public class Avion extends Nave {
	private static final long serialVersionUID = 1L;

	private String aerolinea;

	@Column(name="numero_bodegas")
	private int numeroBodegas;

	//bi-directional many-to-one association to Nave
	@ManyToOne
	private Nave nave;

	public Avion() {
	}

	public String getAerolinea() {
		return this.aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public int getNumeroBodegas() {
		return this.numeroBodegas;
	}

	public void setNumeroBodegas(int numeroBodegas) {
		this.numeroBodegas = numeroBodegas;
	}

	public Nave getNave() {
		return this.nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

}