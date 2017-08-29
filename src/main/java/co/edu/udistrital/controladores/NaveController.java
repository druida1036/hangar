package co.edu.udistrital.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.edu.udistrital.controladores.convertidores.ComponenteConverter;
import co.edu.udistrital.modelo.Componente;
import co.edu.udistrital.modelo.Nave;
import co.edu.udistrital.servicios.NaveService;

@Controller
public class NaveController {
	
	@Autowired
	private NaveService service;
	@Autowired
	private ComponenteConverter componenteConverter;
	private List<Nave> listado;
	private Nave registro;
	private List<Componente> registroComponente;
	
	@PostConstruct
	public void init(){
		listado = service.consultar();
	}
	
	public void completarRegistro(){
		registro = service.consultar(registro.getId());
	}

    public List<Nave> completarNaves(String query) {
        List<Nave> naves = service.consultar();
        List<Nave> navesFiltradas = new ArrayList<Nave>();
         
        for (int i = 0; i < naves.size(); i++) {
            Nave nave = naves.get(i);
            if(nave.getFabricante().toLowerCase().startsWith(query)) {
                navesFiltradas.add(nave);
            }
        }
         
        return navesFiltradas;
    }
    
    public void cargarComponentes(){
    	componenteConverter.setListado(registro.getComponentes());
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
	 * @param registroComponente the registroComponente to set
	 */
	public void setRegistroComponente(List<Componente> registroComponente) {
		this.registroComponente = registroComponente;
	}

}
