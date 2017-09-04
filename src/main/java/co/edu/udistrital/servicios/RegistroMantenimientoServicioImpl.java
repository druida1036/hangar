package co.edu.udistrital.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.dao.RegistroMantenimientoDAO;
import co.edu.udistrital.modelo.RegistroMantenimiento;

@Service
public class RegistroMantenimientoServicioImpl implements RegistroMantenimientoService {
	
	@Autowired
	private RegistroMantenimientoDAO dao;

	@Override
	public RegistroMantenimiento crear(RegistroMantenimiento registroMantenimiento) {
		return dao.crear(registroMantenimiento);
	}

	@Override
	public RegistroMantenimiento actualizar(RegistroMantenimiento registroMantenimiento) {
		return dao.actualizar(registroMantenimiento);
	}

	@Override
	public RegistroMantenimiento consultar(int id) {
		return dao.consultar(id);
	}

	@Override
	public List<RegistroMantenimiento> consultar() {
		return dao.consultar();
	}

}
