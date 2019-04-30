package org.agenda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class DettaglioOrdine implements Serializable {

	private static final long serialVersionUID = 1L;

	public DettaglioOrdine() {
	}

	@Id
	private long id;
	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "Prodotto_id", referencedColumnName = "id")
	private Prodotto prodotto;
	private int qta;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto param) {
		this.prodotto = param;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int param) {
		this.qta = param;
	}

}