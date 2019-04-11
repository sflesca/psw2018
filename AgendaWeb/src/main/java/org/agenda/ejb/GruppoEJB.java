package org.agenda.ejb;

import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenda.model.*;

/**
 * Session Bean implementation class GruppoEJB
 */
@Stateless(mappedName = "GruppoEJB")
@LocalBean
public class GruppoEJB {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public GruppoEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Gruppo> findAllGroups() {
		Query q = em.createNamedQuery("findAllGroups");
		return q.getResultList();
    }
    
    public Gruppo findGroupWithPersons(long gid) {
    	Gruppo g = em.find(Gruppo.class, gid);
    	g.getPersona().size();
    	return g;
    }
    
    public Gruppo findGroupWithoutPersons(long gid) {
    	return em.find(Gruppo.class, gid);
    }
    
    public Gruppo inserisciGruppo(String nome) {
    	Gruppo g = new Gruppo();
    	g.setNome(nome);
    	em.persist(g);
    	return g;
    }
}
