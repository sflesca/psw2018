package org.prodotti.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.QueryParam;

import org.prodotti.model.Ordine;
import org.prodotti.model.Prodotto;

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
	
	public List<Prodotto> findAllProducts(final Integer startPosition,
			final Integer maxResult) {
		Query q = em.createNamedQuery("findAllProducts");
		return q.setFirstResult(startPosition).setMaxResults(maxResult).getResultList();
	}

    public Prodotto inserisciProdotto(String nome, int qta, double price) {
    	Prodotto p = new Prodotto();
    	p.setNome(nome);
    	p.setQta(qta);
    	p.setPrice(price);
    	em.persist(p);
    	return p;
    }
    
    public Prodotto inserisciProdotto(String nome, double price) {
    	Prodotto p = new Prodotto();
    	p.setNome(nome);
    	p.setQta(0);
    	p.setPrice(price);
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

	@Override
	public Prodotto find(long pid) {
		Prodotto p = em.find(Prodotto.class, pid);
    	return p;
	}

}
