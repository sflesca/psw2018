package org.agenda.model;

import java.util.*;

public class PersoneBean {
	
	private Gruppo group = null;
	private List<Gruppo> groups = new ArrayList<Gruppo>();
	private List<Persona> pers = new ArrayList<Persona>();

	public String getGroupName() {
		return (group!=null)?group.getNome():"Nessun gruppo selezionato";
	}

	public void setGroup(Gruppo g) {
		this.group = g;
	}

	public List<Persona> getPers() {
		return pers;
	}
	
	public List<Gruppo> getGroups() {
		return groups;
	}
	
}
