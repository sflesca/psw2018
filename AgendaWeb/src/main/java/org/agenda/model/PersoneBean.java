package org.agenda.model;

import java.util.*;

public class PersoneBean {
	
	private String groupName = "Nessuno";
	List<Persona> pers = new ArrayList<Persona>();

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Persona> getPers() {
		return pers;
	}

}
