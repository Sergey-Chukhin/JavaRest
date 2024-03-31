package org.donstu.controllers;

import org.donstu.domain.Voyage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/voyages")
public class VoyageController {
    private static List<Voyage> voyages = new ArrayList<>();

    static {
        voyages.add(new Voyage("Greece in eight days","Piraeus - Crete - Rhodes - Olympia - Corfu - Piraeus", new Date(), 8, "First"));
        voyages.add(new Voyage("Circle of Asia","Tokyo - Shanghai - Taipei - Hong Kong - Nha Trang - Singapore", new Date(), 19, "Second"));
        voyages.add(new Voyage("Mystical beauty","Bermuda - Bahamas - Bermuda", new Date(), 7, "Second"));
        voyages.add(new Voyage("Antarctic summer","Argentina - Antarctica", new Date(), 15, "First"));
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response defaultPath() {
        return getVoyages();
    }

    @GET
    @Path("/list")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getVoyages() {
        GenericEntity<List<Voyage>> genericEntity = new GenericEntity<List<Voyage>>(voyages) {
        };
        return Response.ok(genericEntity).build();
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getVoyages(@PathParam("id") String id) {
        int num = Integer.parseInt(id);
        if (voyages.size() <= num) {
            return Response.ok().build();
        } else {
            return Response.ok(voyages.get(num)).build();
        }
    }
}
