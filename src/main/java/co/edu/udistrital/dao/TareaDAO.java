package co.edu.udistrital.dao;

import java.util.List;

import co.edu.udistrital.modelo.Tarea;

public interface TareaDAO {
	
	public Tarea crear(Tarea tarea);
	public Tarea actualizar(Tarea tarea);
	public void borrar(long id);
	public Tarea consultar(long id);
	public List<Tarea> consultar();

}
