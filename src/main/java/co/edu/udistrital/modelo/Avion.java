package co.edu.udistrital.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avion database table.
 * 
 */
@Entity
@NamedQuery(name="Avion.findAll", query="SELECT a FROM Avion a")
public class Avion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AvionPK id;

	private String aerolinea;

	@Column(name="numero_bodegas")
	private int numeroBodegas;

	//bi-directional many-to-one association to Nave
	@ManyToOne
	private Nave nave;

	public Avion() {
	}

	public AvionPK getId() {
		return this.id;
	}

	public void setId(AvionPK id) {
		this.id = id;
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