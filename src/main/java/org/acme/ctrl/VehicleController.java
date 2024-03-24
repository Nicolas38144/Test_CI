package org.acme.ctrl;

import io.quarkus.logging.Log;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/game")
public class VehicleController {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGame(String name){
        Log.info(name);
        return Response.status(200).entity(name).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameState(){
        Log.info("Getting game state");
        return Response.status(200).build();
    }

    @Path("/vehicule")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createVehicule(Vehicule vehicule){
        // Appeler le svc pour créer un véhicule
        // Appeler le mqtt service pour publier l'état du jeu
        // Envoyer la réponse
        Log.info(vehicule.getName());
        return Response.status(200).entity(vehicule.getName()).build();
    }
}
