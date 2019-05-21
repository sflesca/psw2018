package org.agenda.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
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

import org.agenda.model.Ordine;

@RequestScoped
@Path("/ordines")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class OrdineEndpoint {

	@POST
	public Response create(final Ordine ordine) {
		//TODO: process the given ordine 
		//here we use Ordine#getId(), assuming that it provides the identifier to retrieve the created Ordine resource. 
		return Response
				.created(UriBuilder.fromResource(OrdineEndpoint.class).path(String.valueOf(ordine.getId())).build())
				.build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the ordine 
		Ordine ordine = null;
		if (ordine == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(ordine).build();
	}

	@GET
	public List<Ordine> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the ordines 
		final List<Ordine> ordines = null;
		return ordines;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final Ordine ordine) {
		//TODO: process the given ordine 
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the ordine matching by the given id 
		return Response.noContent().build();
	}

}
