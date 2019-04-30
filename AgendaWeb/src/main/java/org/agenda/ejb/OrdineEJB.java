package org.agenda.ejb;

import java.util.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenda.model.*;


/**
 * Session Bean implementation class OrdineEJB
 */
@Stateless(mappedName = "OrdineEJB")
@LocalBean
public class OrdineEJB {

	@PersistenceContext
	EntityManager em;
	
	/**
     * Default constructor. 
     */
    public OrdineEJB() {
        // TODO Auto-generated constructor stub
    }


	public List<Ordine> findAllOrders() {
		Query q = em.createNamedQuery("findAllOrders");
		return q.getResultList();
	}

    public Ordine inserisciOrdine(Ordine o) {
    	em.persist(o);
    	return o;
    }
    
 
    public Ordine aggiorna(Ordine o) {
    	return em.merge(o);
    }
    
    public void remove(Ordine o) {
    	em.remove(o);
    }
    
    public DettaglioOrdine inserisciDettaglioOrdine(DettaglioOrdine dt) {
    	em.persist(dt);
    	return dt;
    }
    
    public Ordine find(long oid) {
    	Ordine o = em.find(Ordine.class, oid);
    	o.getDettaglioOrdine().size();
    	return o;
    }
    
}
