package co.edu.udistrital.modelo.dao;

import java.util.List;

import co.edu.udistrital.modelo.entidades.PlanMantenimiento;

public interface PlanMantenimientoDAO {
	
	public PlanMantenimiento crear(PlanMantenimiento planMantenimiento);
	public PlanMantenimiento actualizar(PlanMantenimiento planMantenimiento);
	public void borrar(long id);
	public PlanMantenimiento consultar(long id);
	public List<PlanMantenimiento> consultar();

}
