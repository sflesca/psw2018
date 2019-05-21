package org.prodotti.model;

import java.io.Serializable;
import javax.persistence.*;

import org.prodotti.model.DettaglioOrdine;

import java.util.*;

@Entity
@Table(name = "Ordine")
@NamedQueries({
	@NamedQuery(name = "findAllOrders", query = "select o from Ordine o LEFT JOIN FETCH o.dettaglioOrdine")
	})
public class Ordine implements Serializable {

	private static final long serialVersionUID = 1L;

	public Ordine() {
	}

	@Id@GeneratedValue
	private long id;
	@OneToMany(cascade = {CascadeType.PERSIST})
	private Collection<DettaglioOrdine> dettaglioOrdine = new ArrayList<DettaglioOrdine>(5);
	
	private Date data;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<DettaglioOrdine> getDettaglioOrdine() {
	    return dettaglioOrdine;
	}

	public void setDettaglioOrdine(Collection<DettaglioOrdine> param) {
	    this.dettaglioOrdine = param;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		Ordine other = (Ordine) obj;
		if (id != other.id)
			return false;
		return true;
	}

}