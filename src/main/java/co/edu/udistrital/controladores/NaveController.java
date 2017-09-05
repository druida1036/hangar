package co.edu.udistrital.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.edu.udistrital.controladores.servicios.NaveService;
import co.edu.udistrital.modelo.entidades.Avion;
import co.edu.udistrital.modelo.entidades.Componente;
import co.edu.udistrital.modelo.entidades.Nave;

@Controller
@Scope("session")
public class NaveController {

	@Autowired
	private NaveService service;
	private List<Nave> listado;
	private Nave registro;
	private List<Componente> registroComponente;

	@PostConstruct
	public void init() {
		listado = service.consultar();
	}

	public void completarRegistro() {
		registro = service.consultar(registro.getId());
	}

	public void borrarNave() {
		service.borrar(registro);
		registro = new Avion();
		init();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful", "Your message: " + "Nave borrada"));
	}

	public List<Nave> completarNaves(String query) {
		List<Nave> naves = service.consultar();
		List<Nave> navesFiltradas = new ArrayList<Nave>();

		for (int i = 0; i < naves.size(); i++) {
			Nave nave = naves.get(i);
			if (nave.getFabricante().toLowerCase().startsWith(query)) {
				navesFiltradas.add(nave);
			}
		}

		return navesFiltradas;
	}

	public void handleChange() {
		System.out.println("New value: " + registro.getFabricante());
		completarRegistro();
	}

	public void cargarComponentes() {
		// componenteConverter.setListado(registro.getComponentes());
	}

	public List<Nave> getListado() {
		return listado;
	}

	public void setListado(List<Nave> listado) {
		this.listado = listado;
	}

	public Nave getRegistro() {
		return registro;
	}

	public void setRegistro(Nave registro) {
		this.registro = registro;
	}

	/**
	 * @return the registroComponente
	 */
	public List<Componente> getRegistroComponente() {
		return registroComponente;
	}

	/**
	 * @param registroComponente
	 *            the registroComponente to set
	 */
	public void setRegistroComponente(List<Componente> registroComponente) {
		this.registroComponente = registroComponente;
	}

}
