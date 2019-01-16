package co.edu.udistrital.modelo.dao;

import java.util.List;

import co.edu.udistrital.modelo.entidades.Componente;

public interface ComponenteDAO {
	
	public Componente crear(Componente componente);
	public Componente actualizar(Componente componente);
	public void borrar(long id);
	public Componente consultar(long id);
	public List<Componente> consultar();

}
