package org.agenda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.agenda.model.Gruppo;
import javax.persistence.ManyToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAllPersons", query = "select p from Persona p"),
	@NamedQuery(name = "findPersonsByGroupId", query = "select p from Persona p where p.gruppo.id = :groupid")
	})
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Persona() {
	}

	@Id@GeneratedValue
	private long id;
	private String nome;
	@ManyToOne
	private Gruppo gruppo;
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

	public Gruppo getGruppo() {
	    return gruppo;
	}

	public void setGruppo(Gruppo param) {
	    this.gruppo = param;
	}

}