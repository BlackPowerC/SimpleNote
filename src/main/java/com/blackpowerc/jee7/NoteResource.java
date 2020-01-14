package com.blackpowerc.jee7;

import javax.inject.Inject;
import javax.json.Json;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/notes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NoteResource
{
    @Inject
    private ReadOperation readService ;

    @Inject
    private UpdateOperation updateService ;

    private final UriBuilder uriBuilder = UriBuilder.fromResource(getClass()) ;

    public NoteResource() {
    }

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok(
                Json.createObjectBuilder().add("message", "hello").build()
        ).build() ;
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") final int id)
    {
        Note note = readService.findById(id).get() ;

        return Response.ok(note).build();
    }

    @GET
    public Response find(@QueryParam("perPage") @Min(1) final int perPage, @QueryParam("page") @Min(1) final int page) {
        return Response.ok(readService.find(perPage, page)).build();
    }

    @DELETE
    public Response deleteAll() {
        return Response.ok().build() ;
    }

    @Path("/{id}")
    @DELETE
    public Response deleteById(@PathParam("id") final long id) {
        return Response.ok().build() ;
    }

    @PUT
    public Response update(@Valid Note note)
    {
        Note updated = updateService.update(note) ;
        return Response.ok(updated)
                .link(uriBuilder.resolveTemplate("/{id}", note.getId()).build(), "rel")
                .build() ;
    }

    @POST
    public Response insert(@Valid Note note)
    {
        updateService.insert(note) ;
        return Response.ok(note)
                .link(uriBuilder.resolveTemplate("/{id}", note.getId()).build(), "rel")
                .build() ;
    }
}
