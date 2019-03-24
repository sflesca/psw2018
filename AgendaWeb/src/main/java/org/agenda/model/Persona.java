package org.agenda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.agenda.model.Gruppo;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name = "findAllPersons", query = "select p from Persona p"),@NamedQuery(name = "findByGroupId", query = "select p from Persona p\r\nwhere p.gruppo.id =[groupid]")})
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	public Persona() {
	}

	@Id
	private long id;
	private String nome;
	@OneToMany(mappedBy = "persona")
	private Collection<Gruppo> gruppo;
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

	public Collection<Gruppo> getGruppo() {
	    return gruppo;
	}

	public void setGruppo(Collection<Gruppo> param) {
	    this.gruppo = param;
	}

}