package co.edu.udistrital.dao;

import java.util.List;

import co.edu.udistrital.modelo.Nave;

public interface NaveDAO {
	
	public Nave crear(Nave nave);
	public Nave actualizar(Nave nave);
	public void borrar(long id);
	public Nave consulta(long id);
	public List<Nave> consulta();

}
