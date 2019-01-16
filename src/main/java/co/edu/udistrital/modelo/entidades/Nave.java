package co.edu.udistrital.modelo.entidades;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the nave database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Nave.findAll", query="SELECT n FROM Nave n")
public abstract class Nave implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String estado;

	private String fabricante;

	private String referencia;


	//bi-directional many-to-one association to Componente
	@OneToMany(mappedBy="nave", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Componente> componentes = new ArrayList<Componente>();


	//bi-directional many-to-one association to RegistroMantenmiento
	@OneToMany(mappedBy="nave")
	@JsonManagedReference
	private List<RegistroMantenimiento> registroMantenmientos = new ArrayList<RegistroMantenimiento>();

	public Nave() {
	}

	public abstract String getLogo();
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public List<Componente> getComponentes() {
		return this.componentes;
	}

	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	public Componente addComponente(Componente componente) {
		getComponentes().add(componente);
		componente.setNave(this);

		return componente;
	}

	public Componente removeComponente(Componente componente) {
		getComponentes().remove(componente);
		componente.setNave(null);

		return componente;
	}

//	public List<Helicoptero> getHelicopteros() {
//		return this.helicopteros;
//	}
//
//	public void setHelicopteros(List<Helicoptero> helicopteros) {
//		this.helicopteros = helicopteros;
//	}

//	public Helicoptero addHelicoptero(Helicoptero helicoptero) {
//		getHelicopteros().add(helicoptero);
//		helicoptero.setNave(this);
//
//		return helicoptero;
//	}
//
//	public Helicoptero removeHelicoptero(Helicoptero helicoptero) {
//		getHelicopteros().remove(helicoptero);
//		helicoptero.setNave(null);
//
//		return helicoptero;
//	}

	public List<RegistroMantenimiento> getRegistroMantenmientos() {
		return this.registroMantenmientos;
	}

	public void setRegistroMantenmientos(List<RegistroMantenimiento> registroMantenmientos) {
		this.registroMantenmientos = registroMantenmientos;
	}

	public RegistroMantenimiento addRegistroMantenmiento(RegistroMantenimiento registroMantenmiento) {
		getRegistroMantenmientos().add(registroMantenmiento);
		registroMantenmiento.setNave(this);

		return registroMantenmiento;
	}

	public RegistroMantenimiento removeRegistroMantenmiento(RegistroMantenimiento registroMantenmiento) {
		getRegistroMantenmientos().remove(registroMantenmiento);
		registroMantenmiento.setNave(null);

		return registroMantenmiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Nave other = (Nave) obj;
		if (id != other.id)
			return false;
		return true;
	}

}