package org.agenda.view;

import javax.inject.Named;

import org.agenda.ejb.GruppoEJB;
import org.agenda.ejb.PersoneEJB;
import org.agenda.ejb.ProdottoEJB;
import org.agenda.model.Gruppo;
import org.agenda.model.Persona;
import org.agenda.model.Prodotto;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="dashBoard")
@ViewScoped
public class DashBoard {
	
	@EJB
	PersoneEJB pEJB;
	
	@EJB
	GruppoEJB gEJB;
	
	@EJB
	ProdottoEJB prodEJB;
	
	
	public DashBoard() {

	}
	
	@PostConstruct
    public void init(){
		groups= gEJB.findAllGroups();
		pers=pEJB.findAllPersons();
    }

	private Gruppo group = null;
	private List<Gruppo> groups = new ArrayList<Gruppo>();
	private List<Persona> pers = new ArrayList<Persona>();

	public String getGroupName() {
		return (group!=null)?group.getNome():"Nessun gruppo selezionato";
	}

	public Gruppo getGroup() {
		return group;
	}
	
	public void setGroup(Gruppo g) {
		this.group = g;
	}

	public List<Persona> getPers() {
		return pers;
	}
	
	public void setPers(List<Persona> pers) {
		this.pers = pers;
	}

	public List<Gruppo> getGroups() {
		return groups;
	}
	
	public String changeGroup(long gid) {
		if (gid==-1) {
			setGroup(null);
			setPers(pEJB.findAllPersons());
		}else {
			Gruppo g = gEJB.findGroupWithPersons(gid);
			setGroup(g);
			setPers(g.getPersona());
		}
		return null;
	}

	
	public List<Prodotto> getProdotti() {
		return prodEJB.findAllProducts();
	}
}