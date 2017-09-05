package co.edu.udistrital.modelo.dao;

import java.util.List;

import co.edu.udistrital.modelo.entidades.RegistroMantenimiento;

public interface RegistroMantenimientoDAO {
	
	public RegistroMantenimiento crear(RegistroMantenimiento registroMantenimiento);
	public RegistroMantenimiento actualizar(RegistroMantenimiento registroMantenimiento);
	public void borrar(long id);
	public RegistroMantenimiento consultar(long id);
	public List<RegistroMantenimiento> consultar();

}
