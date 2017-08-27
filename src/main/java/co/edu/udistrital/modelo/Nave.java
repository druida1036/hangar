package co.edu.udistrital.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the nave database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Nave.findAll", query="SELECT n FROM Nave n")
public class Nave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String estado;

	private String fabricante;

	private String referencia;


	//bi-directional many-to-one association to Componente
	@OneToMany(mappedBy="nave", cascade = CascadeType.ALL)
	private List<Componente> componentes = new ArrayList<Componente>();


	//bi-directional many-to-one association to RegistroMantenmiento
	@OneToMany(mappedBy="nave")
	private List<RegistroMantenmiento> registroMantenmientos = new ArrayList<RegistroMantenmiento>();

	public Nave() {
	}

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

	public List<RegistroMantenmiento> getRegistroMantenmientos() {
		return this.registroMantenmientos;
	}

	public void setRegistroMantenmientos(List<RegistroMantenmiento> registroMantenmientos) {
		this.registroMantenmientos = registroMantenmientos;
	}

	public RegistroMantenmiento addRegistroMantenmiento(RegistroMantenmiento registroMantenmiento) {
		getRegistroMantenmientos().add(registroMantenmiento);
		registroMantenmiento.setNave(this);

		return registroMantenmiento;
	}

	public RegistroMantenmiento removeRegistroMantenmiento(RegistroMantenmiento registroMantenmiento) {
		getRegistroMantenmientos().remove(registroMantenmiento);
		registroMantenmiento.setNave(null);

		return registroMantenmiento;
	}

}