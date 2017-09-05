package co.edu.udistrital.controladores.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.modelo.dao.TareaDAO;
import co.edu.udistrital.modelo.entidades.Tarea;

@Service
public class TareaServicioImpl implements TareaService {
	
	@Autowired
	private TareaDAO dao;

	@Override
	public Tarea crear(Tarea tarea) {
		return dao.crear(tarea);
	}

	@Override
	public Tarea actualizar(Tarea tarea) {
		return dao.actualizar(tarea);
	}

	@Override
	public Tarea consultar(int id) {
		return dao.consultar(id);
	}

	@Override
	public List<Tarea> consultar() {
		return dao.consultar();
	}

}
