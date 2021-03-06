package co.edu.udistrital.modelo.dao;

import java.util.List;

import co.edu.udistrital.modelo.entidades.DetalleMantenimiento;

public interface DetalleMantenimientoDAO {
	
	public DetalleMantenimiento crear(DetalleMantenimiento detalleMantenimiento);
	public DetalleMantenimiento actualizar(DetalleMantenimiento detalleMantenimiento);
	public void borrar(long id);
	public DetalleMantenimiento consultar(long id);
	public List<DetalleMantenimiento> consultar();

}
