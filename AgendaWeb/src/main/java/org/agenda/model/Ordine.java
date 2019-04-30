package org.agenda.model;

import java.io.Serializable;
import javax.persistence.*;

import org.agenda.model.DettaglioOrdine;

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

	@Id
	private long id;
	@OneToMany(cascade = {CascadeType.PERSIST})
	private Collection<DettaglioOrdine> dettaglioOrdine = new ArrayList<DettaglioOrdine>(5);

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

}