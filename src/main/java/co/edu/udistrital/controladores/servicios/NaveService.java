package co.edu.udistrital.controladores.servicios;

import java.util.List;

import co.edu.udistrital.modelo.entidades.Componente;
import co.edu.udistrital.modelo.entidades.Nave;

public interface NaveService {
	
	public Nave crear(Nave nave, List<Componente> componentes);
	public Nave actualizar(Nave nave);
	public Nave consultar(int id);
	public List<Nave> consultar();
	public void borrar(Nave nave);
}
