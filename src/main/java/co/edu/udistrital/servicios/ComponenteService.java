package co.edu.udistrital.servicios;

import java.util.List;

import co.edu.udistrital.modelo.Componente;

public interface ComponenteService {
	
	public Componente crear(Componente componente);
	public Componente actualizar(Componente componente);
	public Componente consultar(int id);
	public List<Componente> consultar();
}
