package co.edu.udistrital.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.modelo.entidades.PlanMantenimiento;

@Repository()
@Transactional
public class PlanMantenimientoDAOImpl implements PlanMantenimientoDAO{
	
	
	private static final String BASE_SELECT = "select planMantenimiento from PlanMantenimiento planMantenimiento";
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public PlanMantenimiento crear(PlanMantenimiento planMantenimiento) {
		
		entityManager.persist(planMantenimiento);
		return planMantenimiento;
	}

	@Transactional(readOnly=false)
	public PlanMantenimiento actualizar(PlanMantenimiento planMantenimiento) {
		entityManager.merge(planMantenimiento);
		return planMantenimiento;
	}

	@Transactional(readOnly=false)
	public void borrar(long customerId) {
	
		
	}

	@Transactional(readOnly=true)
	public PlanMantenimiento consultar(long id) {
		String sql = BASE_SELECT + " where planMantenimiento.id="+id;
		try{
			PlanMantenimiento mantenimiento = (PlanMantenimiento) entityManager.createQuery(sql).getSingleResult();
			Hibernate.isInitialized(mantenimiento.getTareas());
			return (PlanMantenimiento) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<PlanMantenimiento> consultar() {
		
		return entityManager.createQuery(BASE_SELECT).getResultList();
	}

	

}
