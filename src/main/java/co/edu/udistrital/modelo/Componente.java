package co.edu.udistrital.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the componente database table.
 * 
 */
@Entity
@NamedQuery(name="Componente.findAll", query="SELECT c FROM Componente c")
public class Componente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ComponentePK id;

	@Column(name="costo_refraccon")
	private BigDecimal costoRefraccon;

	@Column(name="costo_remplazo")
	private BigDecimal costoRemplazo;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Nave
	@ManyToOne
	private Nave nave;

	public Componente() {
	}

	public ComponentePK getId() {
		return this.id;
	}

	public void setId(ComponentePK id) {
		this.id = id;
	}

	public BigDecimal getCostoRefraccon() {
		return this.costoRefraccon;
	}

	public void setCostoRefraccon(BigDecimal costoRefraccon) {
		this.costoRefraccon = costoRefraccon;
	}

	public BigDecimal getCostoRemplazo() {
		return this.costoRemplazo;
	}

	public void setCostoRemplazo(BigDecimal costoRemplazo) {
		this.costoRemplazo = costoRemplazo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nave getNave() {
		return this.nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

}