package de.predikant.conference.web.rest.api.unsecure;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Path("/private/conference")
public interface ConferenceUnsecureRestService {

    @GET
    Response listAllConferences();

    @GET
    @Path("/{id:[0-9][0-9]*}")
    Response listConferenceById(@PathParam("id") String id);

    @GET
    @Path("/{name}")
    Response listConferencesByName(@PathParam("name") String name);

}