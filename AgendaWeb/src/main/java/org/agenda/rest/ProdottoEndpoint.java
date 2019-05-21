/**
 * 
 */
package org.agenda.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.agenda.ejb.ProdottoEJB;
import org.agenda.model.Prodotto;

/**
 * @author sfles
 *
 */
@RequestScoped
@Path("/prodottoes")
@Produces({ "application/json" })
@Consumes({ "application/json" })
public class ProdottoEndpoint {
	
	@EJB
	ProdottoEJB pEJB;

	/**
	* @param prodotto
	* @return
	*/
	@POST
	public Prodotto create(final Prodotto prodotto) {

		Prodotto p = pEJB.inserisciProdotto(prodotto);
		//here we use Prodotto#getId(), assuming that it provides the identifier to retrieve the created Prodotto resource. 
		return p;
	}

	/**
	* @param id
	* @return
	*/
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		System.out.println("QUI");	
		Prodotto prodotto = pEJB.find(1);
		if (prodotto == null) {
			System.out.println("QUI");
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.ok(prodotto).build();
	}

	/**
	* @param startPosition
	* @param maxResult
	* @return
	*/
	@GET
	public List<Prodotto> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the prodottoes 
		final List<Prodotto> prodottoes = pEJB.findAllProducts(startPosition, maxResult);
		return prodottoes;
	}

	/**
	* @param id
	* @param prodotto
	* @return
	*/
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final Prodotto prodotto) {
		//TODO: process the given prodotto 
		return Response.noContent().build();
	}

	/**
	* @param id
	* @return
	*/
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the prodotto matching by the given id 
		return Response.noContent().build();
	}

}
