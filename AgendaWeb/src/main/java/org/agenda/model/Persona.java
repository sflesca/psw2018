package org.agenda.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Persona")
@NamedQueries(@NamedQuery(name = "findAll", query = "select p from Persona p"))
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Persona() {
	}

	@Id
	private long id;
	private String nome;

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

}