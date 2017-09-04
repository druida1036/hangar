package co.edu.udistrital.servicios;

import java.util.List;

import co.edu.udistrital.modelo.PlanMantenimiento;

public interface PlanMantenimientoService {
	
	public PlanMantenimiento crear(PlanMantenimiento planMantenimiento);
	public PlanMantenimiento actualizar(PlanMantenimiento planMantenimiento);
	public PlanMantenimiento consultar(int id);
	public List<PlanMantenimiento> consultar();
}
