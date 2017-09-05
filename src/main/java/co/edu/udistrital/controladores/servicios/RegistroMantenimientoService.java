package co.edu.udistrital.controladores.servicios;

import java.util.List;

import co.edu.udistrital.modelo.entidades.Componente;
import co.edu.udistrital.modelo.entidades.Nave;
import co.edu.udistrital.modelo.entidades.PlanMantenimiento;
import co.edu.udistrital.modelo.entidades.RegistroMantenimiento;
import co.edu.udistrital.modelo.entidades.Tarea;

public interface RegistroMantenimientoService {
	
	public RegistroMantenimiento crear(Nave nave, PlanMantenimiento plan, List<Componente> componentes, List<Tarea> tareas);
	public RegistroMantenimiento actualizar(RegistroMantenimiento registroMantenimiento);
	public RegistroMantenimiento consultar(int id);
	public List<RegistroMantenimiento> consultar();
}
