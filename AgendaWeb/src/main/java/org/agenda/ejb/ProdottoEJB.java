package org.agenda.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.agenda.model.Gruppo;
import org.agenda.model.Prodotto;

/**
 * Session Bean implementation class Prodotto
 */
@Stateless(mappedName = "ProdottoEJB")
@LocalBean
public class ProdottoEJB implements ProdottoLocal {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public ProdottoEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Prodotto> findAllProducts() {
		Query q = em.createNamedQuery("findAllProducts");
		return q.getResultList();
	}

    public Prodotto inserisciProdotto(String nome, int qta) {
    	Prodotto p = new Prodotto();
    	p.setNome(nome);
    	p.setQta(qta);
    	em.persist(p);
    	return p;
    }
    
    public Prodotto inserisciProdotto(String nome) {
    	Prodotto p = new Prodotto();
    	p.setNome(nome);
    	p.setQta(0);
    	em.persist(p);
    	return p;
    }
    
    public Prodotto aggiorna(Prodotto p) {
    	return em.merge(p);
    }
    
    public void remove(Prodotto p) {
    	em.remove(p);
    }

	@Override
	public Prodotto inserisciProdotto(Prodotto p) {
    	em.persist(p);
    	return p;
	}

}
