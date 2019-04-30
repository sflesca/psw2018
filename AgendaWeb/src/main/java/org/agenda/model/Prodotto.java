package org.agenda.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.agenda.model.Prodotto;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Prodotto")
@NamedQueries({
	@NamedQuery(name = "findAllProducts", query = "select p from Prodotto p")
	})
public class Prodotto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Prodotto() {
	}

	@Id@GeneratedValue
	private long id;
	private String nome;
	private int qta;

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

	public int getQta() {
		return qta;
	}

	public void setQta(int param) {
		this.qta = param;
	}


}