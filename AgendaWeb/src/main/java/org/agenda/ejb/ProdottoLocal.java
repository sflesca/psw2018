package org.agenda.ejb;

import java.util.List;

import javax.ejb.Local;


import org.agenda.model.Gruppo;
import org.agenda.model.Prodotto;

@Local
public interface ProdottoLocal {
	
    public List<Prodotto> findAllProducts();
    
    public Prodotto inserisciProdotto(String nome, int qta);
    
    public Prodotto inserisciProdotto(String nome);
    
    public Prodotto inserisciProdotto(Prodotto p);
    
    public Prodotto aggiorna(Prodotto p);
    
    public void remove(Prodotto p);

}
