package co.edu.udistrital.servicios;

import java.util.List;

import co.edu.udistrital.modelo.RegistroMantenimiento;

public interface RegistroMantenimientoService {
	
	public RegistroMantenimiento crear(RegistroMantenimiento registroMantenimiento);
	public RegistroMantenimiento actualizar(RegistroMantenimiento registroMantenimiento);
	public RegistroMantenimiento consultar(int id);
	public List<RegistroMantenimiento> consultar();
}
