package org.agenda.ejb;

import java.util.*;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenda.model.*;

/**
 * Session Bean implementation class PersoneEJB
 */
@Stateless(mappedName = "PersoneEJB")
@LocalBean
public class PersoneEJB {
	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	GruppoEJB gEJB;

    /**
     * Default constructor. 
     */
    public PersoneEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Persona> findAllPersons(){
		Query q = em.createNamedQuery("findAllPersons");
		return q.getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED) 
    public Persona inserisciPersona(String nome, long gid) {
    	Persona p =new Persona();
    	p.setNome(nome);
    	Gruppo g = gEJB.findGroupWithoutPersons(gid);
    	p.setGruppo(g);
    	g.getPersona().add(p);
    	em.persist(p);
    	return p;
    }
}
