package co.edu.udistrital.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


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
	
	private Date fecha;
	
	private BigDecimal total;

	//bi-directional many-to-one association to Nave
	@ManyToOne(optional = true)
	@JsonBackReference
	private Nave nave;

	//bi-directional many-to-one association to PlanMantenimiento
	@ManyToOne()
	@JoinColumn(name="plan_mantenimiento_id")
	@JsonManagedReference
	private PlanMantenimiento planMantenimiento;
	
	@OneToMany(mappedBy="mantenmiento", cascade = CascadeType.ALL)
	@JsonManagedReference
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

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}