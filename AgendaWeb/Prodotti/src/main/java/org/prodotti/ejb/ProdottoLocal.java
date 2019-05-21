package org.prodotti.ejb;

import java.util.List;

import javax.ejb.Local;


import org.prodotti.model.Prodotto;

@Local
public interface ProdottoLocal {
	
    public List<Prodotto> findAllProducts();
    
    public Prodotto find(long pid);
    
    public Prodotto inserisciProdotto(String nome, int qta, double price);
    
    public Prodotto inserisciProdotto(String nome, double price);
    
    public Prodotto inserisciProdotto(Prodotto p);
    
    public Prodotto aggiorna(Prodotto p);
    
    public void remove(Prodotto p);
    
	public List<Prodotto> findAllProducts(Integer startPosition, Integer maxResult);

}
