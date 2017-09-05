package co.edu.udistrital.modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.modelo.entidades.Componente;

@Repository()
@Transactional
public class ComponenteDAOImpl implements ComponenteDAO{
	
	
	private static final String BASE_SELECT = "select componente from Componente componente";
	@PersistenceContext
	public EntityManager entityManager;

	@Transactional(readOnly=false)
	public Componente crear(Componente componente) {
		
		entityManager.persist(componente);
		return componente;
	}

	@Transactional(readOnly=false)
	public Componente actualizar(Componente componente) {
		entityManager.merge(componente);
		return componente;
	}

	@Transactional(readOnly=false)
	public void borrar(long customerId) {
	
		
	}

	@Transactional(readOnly=true)
	public Componente consultar(long id) {
		String sql = BASE_SELECT + " where componente.id="+id;
		try{
			return (Componente) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e){
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Componente> consultar() {
		
		return entityManager.createQuery(BASE_SELECT).getResultList();
	}

	

}
