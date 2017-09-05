package co.edu.udistrital.controladores.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.modelo.dao.NaveDAO;
import co.edu.udistrital.modelo.entidades.Componente;
import co.edu.udistrital.modelo.entidades.Nave;

@Service
public class NaveServicioImpl implements NaveService {
	
	@Autowired
	private NaveDAO dao;

	@Override
	public Nave crear(Nave nave, List<Componente> componentes) {
		nave.setComponentes(componentes);
		return dao.crear(nave);
	}

	@Override
	public Nave actualizar(Nave nave) {
		return dao.actualizar(nave);
	}

	@Override
	public Nave consultar(int id) {
		return dao.consultar(id);
	}

	@Override
	public List<Nave> consultar() {
		return dao.consultar();
	}

	@Override
	public void borrar(Nave nave) {
		dao.borrar(nave);
		
	}

}
