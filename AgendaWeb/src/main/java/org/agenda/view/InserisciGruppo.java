package org.agenda.view;

import javax.inject.Named;

import org.agenda.ejb.*;
import org.agenda.model.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="inserisciGruppo")
@ViewScoped
public class InserisciGruppo {
	
	String gname;
	
	@EJB
	GruppoEJB gEJB;


	
	public String getGname() {
		return gname;
	}



	public void setGname(String gname) {
		this.gname = gname;
	}



	public String inserisci() {
		if(gname==null||gname.equals(""))
			return null;
		gEJB.inserisciGruppo(gname);
		return "dash";
	}
	
}