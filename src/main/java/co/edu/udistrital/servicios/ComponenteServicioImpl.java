package co.edu.udistrital.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.dao.ComponenteDAO;
import co.edu.udistrital.modelo.Componente;

@Service
public class ComponenteServicioImpl implements ComponenteService {
	
	@Autowired
	private ComponenteDAO dao;

	@Override
	public Componente crear(Componente componente) {
		return dao.crear(componente);
	}

	@Override
	public Componente actualizar(Componente componente) {
		return dao.actualizar(componente);
	}

	@Override
	public Componente consultar(int id) {
		return dao.consultar(id);
	}

	@Override
	public List<Componente> consultar() {
		return dao.consultar();
	}

}
