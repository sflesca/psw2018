package org.agenda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class DettaglioOrdine implements Serializable {

	private static final long serialVersionUID = 1L;

	public DettaglioOrdine() {
	}

	@Id@GeneratedValue
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "Prodotto_id", referencedColumnName = "id")
	private Prodotto prodotto;
	
	private int qta;
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Prodotto getProdotto() {
		return prodotto;
	}

	public void setProdotto(Prodotto p) {
		this.prodotto = p;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int param) {
		this.qta = param;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DettaglioOrdine other = (DettaglioOrdine) obj;
		if (id != other.id)
			return false;
		return true;
	}

}