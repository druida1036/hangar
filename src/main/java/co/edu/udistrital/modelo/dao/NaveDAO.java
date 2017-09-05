package co.edu.udistrital.modelo.dao;

import java.util.List;

import co.edu.udistrital.modelo.entidades.Nave;

public interface NaveDAO {
	
	public Nave crear(Nave nave);
	public Nave actualizar(Nave nave);
	public void borrar(Nave nave);
	public Nave consultar(long id);
	public List<Nave> consultar();

}
