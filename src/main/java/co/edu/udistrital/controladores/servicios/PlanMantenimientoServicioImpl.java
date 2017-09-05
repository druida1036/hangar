package co.edu.udistrital.controladores.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.udistrital.modelo.dao.PlanMantenimientoDAO;
import co.edu.udistrital.modelo.entidades.PlanMantenimiento;

@Service
public class PlanMantenimientoServicioImpl implements PlanMantenimientoService {
	
	@Autowired
	private PlanMantenimientoDAO dao;

	@Override
	public PlanMantenimiento crear(PlanMantenimiento planMantenimiento) {
		return dao.crear(planMantenimiento);
	}

	@Override
	public PlanMantenimiento actualizar(PlanMantenimiento planMantenimiento) {
		return dao.actualizar(planMantenimiento);
	}

	@Override
	public PlanMantenimiento consultar(int id) {
		return dao.consultar(id);
	}

	@Override
	public List<PlanMantenimiento> consultar() {
		return dao.consultar();
	}

}
