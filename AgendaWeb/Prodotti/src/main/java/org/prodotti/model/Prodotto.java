package org.prodotti.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.prodotti.model.Prodotto;
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
@XmlRootElement
public class Prodotto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Prodotto() {
	}

	@Id@GeneratedValue
	private long id;
	private String nome;
	private int qta;
	private double price;

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
		Prodotto other = (Prodotto) obj;
		if (id != other.id)
			return false;
		return true;
	}


}