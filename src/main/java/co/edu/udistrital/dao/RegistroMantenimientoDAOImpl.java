package co.edu.udistrital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.modelo.RegistroMantenimiento;

@Repository()
@Transactional
public class RegistroMantenimientoDAOImpl implements RegistroMantenimientoDAO {

	private static final String BASE_SELECT = "select registroMantenimiento from RegistroMantenimiento registroMantenimiento";
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly = false)
	public RegistroMantenimiento crear(RegistroMantenimiento registroMantenimiento) {

		entityManager.persist(registroMantenimiento);
		return registroMantenimiento;
	}

	@Transactional(readOnly = false)
	public RegistroMantenimiento actualizar(RegistroMantenimiento registroMantenimiento) {
		entityManager.merge(registroMantenimiento);
		return registroMantenimiento;
	}

	@Transactional(readOnly = false)
	public void borrar(long customerId) {

	}

	@Transactional(readOnly = true)
	public RegistroMantenimiento consultar(long id) {
		String sql = BASE_SELECT + " where registroMantenimiento.id=" + id;
		try {
			RegistroMantenimiento registroMantenimiento = (RegistroMantenimiento) entityManager.createQuery(sql)
					.getSingleResult();
			Hibernate.initialize(registroMantenimiento.getDetalleMantenimientos());
			return registroMantenimiento;
		} catch (Exception e) {
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<RegistroMantenimiento> consultar() {

		return entityManager.createQuery(BASE_SELECT).getResultList();
	}

}
