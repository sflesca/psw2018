package org.agenda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.agenda.model.Persona;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.OneToMany;

@Entity
@Table(name = "Gruppo")
@NamedQuery(name = "findAllGroups", query = "select g from Gruppo g")
public class Gruppo implements Serializable {

	private static final long serialVersionUID = 1L;

	public Gruppo() {
	}

	@Id@GeneratedValue
	private long id;
	private String nome;
	@OneToMany(mappedBy = "gruppo")
	private List<Persona> persona = new ArrayList<Persona>();
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String param) {
		this.nome = param;
	}

	public List<Persona> getPersona() {
	    return persona;
	}

	public void setPersona(List<Persona> param) {
	    this.persona = param;
	}

}