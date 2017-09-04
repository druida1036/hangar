package co.edu.udistrital.servicios;

import java.util.List;

import co.edu.udistrital.modelo.Tarea;

public interface TareaService {
	
	public Tarea crear(Tarea tarea);
	public Tarea actualizar(Tarea tarea);
	public Tarea consultar(int id);
	public List<Tarea> consultar();
}
