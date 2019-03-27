package org.agenda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.agenda.model.Persona;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
@Table(name = "Gruppo")
@NamedQuery(name = "findAllGroups", query = "select g from Gruppo g")
public class Gruppo implements Serializable {

	private static final long serialVersionUID = 1L;

	public Gruppo() {
	}

	@Id
	private long id;
	private String nome;
	@OneToMany(mappedBy = "gruppo")
	private Collection<Persona> persona;
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

	public Collection<Persona> getPersona() {
	    return persona;
	}

	public void setPersona(Collection<Persona> param) {
	    this.persona = param;
	}

}