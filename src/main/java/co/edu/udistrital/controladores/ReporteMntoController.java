package co.edu.udistrital.controladores;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import co.edu.udistrital.controladores.servicios.RegistroMantenimientoService;
import co.edu.udistrital.modelo.entidades.RegistroMantenimiento;

@Controller
@Scope("session")
public class ReporteMntoController {
	
	@Autowired
	private RegistroMantenimientoService mantenimientoService;
	private RegistroMantenimiento registro;
	private List<RegistroMantenimiento> listado;
	
	@PostConstruct
	public void init(){
		listado = mantenimientoService.consultar();
	}
	
    public void completarRegistro(){
    	registro = mantenimientoService.consultar(registro.getId());
    } 

	/**
	 * @return the listado
	 */
	public List<RegistroMantenimiento> getListado() {
		return listado;
	}

	/**
	 * @param listado the listado to set
	 */
	public void setListado(List<RegistroMantenimiento> listado) {
		this.listado = listado;
	}

	/**
	 * @return the registro
	 */
	public RegistroMantenimiento getRegistro() {
		return registro;
	}

	/**
	 * @param registro the registro to set
	 */
	public void setRegistro(RegistroMantenimiento registro) {
		this.registro = registro;
	}

	
}
