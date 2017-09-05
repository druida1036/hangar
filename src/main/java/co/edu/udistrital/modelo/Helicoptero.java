package co.edu.udistrital.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the helicoptero database table.
 * 
 */
@Entity
@NamedQuery(name="Helicoptero.findAll", query="SELECT h FROM Helicoptero h")
public class Helicoptero extends Nave {
	private static final long serialVersionUID = 1L;

	@Column(name="numero_rotores")
	private int numeroRotores;

	//bi-directional many-to-one association to Nave
	@ManyToOne
	private Nave nave;

	public Helicoptero() {
	}

	public int getNumeroRotores() {
		return this.numeroRotores;
	}

	public void setNumeroRotores(int numeroRotores) {
		this.numeroRotores = numeroRotores;
	}

	public Nave getNave() {
		return this.nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	@Override
	public String getLogo() {
		return "heli";
		
	}

}