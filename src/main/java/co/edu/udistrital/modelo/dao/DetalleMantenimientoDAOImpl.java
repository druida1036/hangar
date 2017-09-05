package co.edu.udistrital.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.modelo.entidades.DetalleMantenimiento;

@Repository()
@Transactional
public class DetalleMantenimientoDAOImpl implements DetalleMantenimientoDAO{
	
	
	private static final String BASE_SELECT = "select detalleMantenimiento from DetalleMantenimiento detalleMantenimiento";
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public DetalleMantenimiento crear(DetalleMantenimiento detalleMantenimiento) {
		
		entityManager.persist(detalleMantenimiento);
		return detalleMantenimiento;
	}

	@Transactional(readOnly=false)
	public DetalleMantenimiento actualizar(DetalleMantenimiento detalleMantenimiento) {
		entityManager.merge(detalleMantenimiento);
		return detalleMantenimiento;
	}

	@Transactional(readOnly=false)
	public void borrar(long customerId) {
	
		
	}

	@Transactional(readOnly=true)
	public DetalleMantenimiento consultar(long id) {
		String sql = BASE_SELECT + " where detalleMantenimiento.id="+id;
		try{
			return (DetalleMantenimiento) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<DetalleMantenimiento> consultar() {
		
		return entityManager.createQuery(BASE_SELECT).getResultList();
	}

	

}
