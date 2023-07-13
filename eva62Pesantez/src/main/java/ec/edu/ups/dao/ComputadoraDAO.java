package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Computadora;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class ComputadoraDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void setEntityManager(EntityManager em) {
        this.em = em;
    }
	
	public void insert(Computadora computadora) {
		em.persist(computadora);
	}
	
	public void update(Computadora computadora) {
		em.merge(computadora);
	}

	public Computadora read(int idComputadora) {
		Computadora c = em.find(Computadora.class, idComputadora);
		return c;
	}

	public void delete(int idComputadora) {
		Computadora c = em.find(Computadora.class, idComputadora);
		em.remove(c);
	}
	
	public List<Computadora> getAll() {
        String jpql = "SELECT c FROM Computadora c";
        TypedQuery<Computadora> query = em.createQuery(jpql, Computadora.class);
        return query.getResultList();
    }
}
