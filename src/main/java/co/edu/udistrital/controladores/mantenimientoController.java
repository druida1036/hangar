package co.edu.udistrital.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.edu.udistrital.controladores.servicios.NaveService;
import co.edu.udistrital.controladores.servicios.PlanMantenimientoService;
import co.edu.udistrital.controladores.servicios.RegistroMantenimientoService;
import co.edu.udistrital.modelo.entidades.Avion;
import co.edu.udistrital.modelo.entidades.Componente;
import co.edu.udistrital.modelo.entidades.Nave;
import co.edu.udistrital.modelo.entidades.PlanMantenimiento;
import co.edu.udistrital.modelo.entidades.Tarea;

@Controller
@Scope("session")
public class mantenimientoController {

	@Autowired
	private NaveService naveService;
	@Autowired
	private PlanMantenimientoService mantenimientoService;
	@Autowired
	private RegistroMantenimientoService registroMantenimientoService;
	private List<Nave> listado;
	private List<PlanMantenimiento> planes;
	private List<Componente> componentes;
	private List<Tarea> tareas;
	private Nave registro;
	private PlanMantenimiento mantenimiento;
	private List<Componente> registroComponente;

	@PostConstruct
	public void init() {
		listado = naveService.consultar();
		planes = mantenimientoService.consultar();
	}

	public void completarRegistro() {
		registro = naveService.consultar(registro.getId());
	}

	public void completarMantenimiento() {
		mantenimiento = mantenimientoService.consultar(mantenimiento.getId());
	}

	public String guardar() {
		registroMantenimientoService.crear(registro, mantenimiento, componentes, tareas);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + "Reporte enviado") );
        limpiar();
        return "reporte.xhtml";
	}

	private void limpiar() {
		registro = new Avion();
		mantenimiento = new PlanMantenimiento();
		componentes.clear();
		tareas.clear();
		
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

	/**
	 * @return the planes
	 */
	public List<PlanMantenimiento> getPlanes() {
		return planes;
	}

	/**
	 * @param planes
	 *            the planes to set
	 */
	public void setPlanes(List<PlanMantenimiento> planes) {
		this.planes = planes;
	}

	/**
	 * @return the mantenimiento
	 */
	public PlanMantenimiento getMantenimiento() {
		return mantenimiento;
	}

	/**
	 * @param mantenimiento
	 *            the mantenimiento to set
	 */
	public void setMantenimiento(PlanMantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	/**
	 * @return the componentes
	 */
	public List<Componente> getComponentes() {
		return componentes;
	}

	/**
	 * @param componentes
	 *            the componentes to set
	 */
	public void setComponentes(List<Componente> componentes) {
		this.componentes = componentes;
	}

	/**
	 * @return the tareas
	 */
	public List<Tarea> getTareas() {
		return tareas;
	}

	/**
	 * @param tareas
	 *            the tareas to set
	 */
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

}
