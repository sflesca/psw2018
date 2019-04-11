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
    	Persona p2 =  new Persona();
    	p2.setNome("Madre");
    	p2.setGruppo(g);
    	g.getPersona().add(p2);  	
    	em.persist(p2);
    	Gruppo gg = new Gruppo();
    	gg.setNome("Amici");
    	em.persist(gg);
    	Persona p3 =  new Persona();
    	p3.setNome("Amico 1");
    	p3.setGruppo(gg);
    	gg.getPersona().add(p3);
    	em.persist(p3);
    	Persona p4 =  new Persona();
    	p4.setNome("Amico 2");
    	p4.setGruppo(gg);
    	gg.getPersona().add(p4);  	
    	em.persist(p4);
    	return true;
    }
    

     
}
