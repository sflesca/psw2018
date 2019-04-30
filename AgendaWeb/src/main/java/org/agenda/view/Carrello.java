package org.agenda.view;

import javax.inject.Named;

import org.agenda.ejb.OrderException;
import org.agenda.ejb.OrderManager;
import org.agenda.model.DettaglioOrdine;
import org.agenda.model.Prodotto;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@ManagedBean(name="carrello")
@SessionScoped
public class Carrello implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	OrderManager omgr;
	
	private HashMap<Long,DettaglioOrdine> contenuto = new HashMap<Long,DettaglioOrdine>();
	
	public String add(Prodotto p) {
		if (contenuto.containsKey(p.getId())) {
			DettaglioOrdine dt = contenuto.get(p.getId());
			dt.setQta(dt.getQta()+1);
		} else {
			DettaglioOrdine dt = new DettaglioOrdine();
			dt.setProdotto(p);
			dt.setPrice(p.getPrice());
			dt.setQta(1);
			contenuto.put(p.getId(), dt);
		}
		return null;
	}
	
	
	public void setQta(Prodotto p, int qta) {
		if(qta<=0) {
			contenuto.remove(p.getId());
			return;
		}
		if (contenuto.containsKey(p.getId())) {
			DettaglioOrdine dt = contenuto.get(p.getId());
			dt.setQta(dt.getQta()+qta);
		} else {
			DettaglioOrdine dt = new DettaglioOrdine();
			dt.setProdotto(p);
			dt.setPrice(p.getPrice());
			dt.setQta(qta);
			contenuto.put(p.getId(), dt);
		}
	}
	
	public void remove(Prodotto p) {
			contenuto.remove(p.getId());
	}
	
	public void order() {
		try {
			omgr.PlaceOrder(new Date(), contenuto.values());
			contenuto.clear();
		} catch (OrderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DettaglioOrdine> getContenuto(){
		ArrayList<DettaglioOrdine> ll = new ArrayList<DettaglioOrdine>();
		for(DettaglioOrdine dt: contenuto.values()) {
			ll.add(dt);
		}
		return ll;
	}
	
	public int numProdotti() {
		return contenuto.size();
	}

}