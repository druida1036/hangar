package co.edu.udistrital.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the registro_mantenmiento database table.
 * 
 */
@Entity
@Table(name="registro_mantenimiento")
@NamedQuery(name="RegistroMantenimiento.findAll", query="SELECT r FROM RegistroMantenimiento r")
public class RegistroMantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Nave
	@ManyToOne
	private Nave nave;

	//bi-directional many-to-one association to PlanMantenimiento
	@ManyToOne()
	@JoinColumn(name="plan_mantenimiento_id")
	private PlanMantenimiento planMantenimiento;
	
	@OneToMany(mappedBy="mantenmiento", cascade = CascadeType.ALL)
	private List<DetalleMantenimiento> detalleMantenimientos = new ArrayList<>();

	public RegistroMantenimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Nave getNave() {
		return this.nave;
	}

	public void setNave(Nave nave) {
		this.nave = nave;
	}

	public PlanMantenimiento getPlanMantenimiento() {
		return this.planMantenimiento;
	}

	public void setPlanMantenimiento(PlanMantenimiento planMantenimiento) {
		this.planMantenimiento = planMantenimiento;
	}

	/**
	 * @return the detalleMantenimientos
	 */
	public List<DetalleMantenimiento> getDetalleMantenimientos() {
		return detalleMantenimientos;
	}

	/**
	 * @param detalleMantenimientos the detalleMantenimientos to set
	 */
	public void setDetalleMantenimientos(List<DetalleMantenimiento> detalleMantenimientos) {
		this.detalleMantenimientos = detalleMantenimientos;
	}

}