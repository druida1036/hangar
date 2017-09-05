package co.edu.udistrital.modelo.dao;

import java.util.List;

import co.edu.udistrital.modelo.entidades.Tarea;

public interface TareaDAO {
	
	public Tarea crear(Tarea tarea);
	public Tarea actualizar(Tarea tarea);
	public void borrar(long id);
	public Tarea consultar(long id);
	public List<Tarea> consultar();

}
