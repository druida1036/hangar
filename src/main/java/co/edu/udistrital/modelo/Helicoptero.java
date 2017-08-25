package co.edu.udistrital.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the helicoptero database table.
 * 
 */
@Entity
@NamedQuery(name="Helicoptero.findAll", query="SELECT h FROM Helicoptero h")
public class Helicoptero implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private HelicopteroPK id;

	@Column(name="numero_rotores")
	private int numeroRotores;

	//bi-directional many-to-one association to Nave
	@ManyToOne
	private Nave nave;

	public Helicoptero() {
	}

	public HelicopteroPK getId() {
		return this.id;
	}

	public void setId(HelicopteroPK id) {
		this.id = id;
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

}