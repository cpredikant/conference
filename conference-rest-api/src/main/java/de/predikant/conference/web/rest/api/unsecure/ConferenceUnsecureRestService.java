package de.predikant.conference.web.rest.api.unsecure;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface ConferenceUnsecureRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAllConferences();

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listConferenceById(@PathParam("id") String id);

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listConferencesByName(@PathParam("name") String name);

}