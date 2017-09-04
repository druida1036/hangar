package co.edu.udistrital.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the componente database table.
 * 
 */
@Entity
@NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c")
@IdClass(ComponentePK.class)
public class Componente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "costo_refraccion")
	private BigDecimal costoRefraccion;

	@Column(name = "costo_remplazo")
	private BigDecimal costoRemplazo;

	private String descripcion;

	private String estado;

	private String nombre;

	// bi-directional many-to-one association to Nave
	@ManyToOne
	@Id
	@JoinColumn(name = " nave_id", insertable = false, updatable = false)
	private Nave nave;

	// bi-directional many-to-one association to RegistroMantenmiento
	@OneToMany(mappedBy = "componente")
	private List<DetalleMantenimiento> detalleMantenimientos = new ArrayList<DetalleMantenimiento>();

	public List<DetalleMantenimiento> getDetalleMantenimientos() {
		return detalleMantenimientos;
	}

	public void setDetalleMantenimientos(List<DetalleMantenimiento> detalleMantenimientos) {
		this.detalleMantenimientos = detalleMantenimientos;
	}

	public Componente() {
	}

	public BigDecimal getCostoRefraccion() {
		return this.costoRefraccion;
	}

	public void setCostoRefraccon(BigDecimal costoRefraccion) {
		this.costoRefraccion = costoRefraccion;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCostoRefraccion(BigDecimal costoRefraccion) {
		this.costoRefraccion = costoRefraccion;
	}

}