package co.edu.udistrital.servicios;

import java.util.List;

import co.edu.udistrital.modelo.Componente;
import co.edu.udistrital.modelo.Nave;
import co.edu.udistrital.modelo.PlanMantenimiento;
import co.edu.udistrital.modelo.RegistroMantenimiento;
import co.edu.udistrital.modelo.Tarea;

public interface RegistroMantenimientoService {
	
	public RegistroMantenimiento crear(Nave nave, PlanMantenimiento plan, List<Componente> componentes, List<Tarea> tareas);
	public RegistroMantenimiento actualizar(RegistroMantenimiento registroMantenimiento);
	public RegistroMantenimiento consultar(int id);
	public List<RegistroMantenimiento> consultar();
}
