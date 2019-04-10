package org.agenda.ejb;

import javax.ejb.*;
import javax.persistence.*;

import org.agenda.model.*;

/**
 * Session Bean implementation class CaricamentoDati
 */
@Stateless(mappedName = "CaricamentoDati")
@LocalBean
public class CaricamentoDati {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CaricamentoDati() {
        // TODO Auto-generated constructor stub
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED) 
    public boolean inserisci() {
    	Gruppo g = new Gruppo();
    	g.setNome("Parenti");
    	em.persist(g);
    	Persona p1 =  new Persona();
    	p1.setNome("Padre");
    	p1.setGruppo(g);
    	g.getPersona().add(p1);
    	em.persist(p1);
   	
    	return true;
    }
     
}
