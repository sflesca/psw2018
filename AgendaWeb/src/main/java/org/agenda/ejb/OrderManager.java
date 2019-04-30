package org.agenda.ejb;

import java.util.*;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.agenda.model.*;

/**
 * Session Bean implementation class OrderManager
 */
@Stateless(mappedName = "OrderManager")
@LocalBean
public class OrderManager {
	
	@EJB
	OrdineEJB oEJB;
	
	@EJB
	ProdottoEJB pEJB;

    /**
     * Default constructor. 
     */
    public OrderManager() {
        // TODO Auto-generated constructor stub
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void PlaceOrder(Date d, Collection<DettaglioOrdine> dts) throws OrderException{
    	Ordine o = new Ordine();
    	o.setData(d);
    	oEJB.inserisciOrdine(o);
    	for(DettaglioOrdine dt:dts) {
    		Prodotto p = pEJB.find(dt.getProdotto().getId());
    		if(p==null) System.out.println("prodotto è null");
    		if(p.getQta()<dt.getQta()) {
    			throw new OrderException(p,false);
    		}
    		if (p.getPrice()!=dt.getPrice()) {
    			throw new OrderException(p,true);
    		}
    		
    		dt.setProdotto(p);
    		oEJB.inserisciDettaglioOrdine(dt);
    		
    		o.getDettaglioOrdine().add(dt);
    		
    		//Aggiorna la quantità disponibile
    		p.setQta(p.getQta()-dt.getQta());
    	}
    }

}
