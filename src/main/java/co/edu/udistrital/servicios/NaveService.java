package co.edu.udistrital.servicios;

import java.util.List;

import co.edu.udistrital.modelo.Componente;
import co.edu.udistrital.modelo.Nave;

public interface NaveService {
	
	public Nave crear(Nave nave, List<Componente> componentes);
	public Nave actualizar(Nave nave);
	public Nave consultar(int id);
	public List<Nave> consultar();
}
