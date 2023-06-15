package rest;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.GsonBuilder;
import facades.ArticleFacade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Map;


@Path("article")
public class ArticleResouurce {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("puTest");
    private static final ArticleFacade articleFacade = ArticleFacade.getFacade(EMF);

    @Context
    private UriInfo context;


    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Article ressource\"}";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all-articles")

    public Response allTrips() throws WebApplicationException {

        return Response.ok(GSON.toJson(articleFacade.getAllObjects()) ,"application/json").build();

    }

    @GET
    @Path("single-article/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getArticleById(@PathParam("id") Long id) throws WebApplicationException {
        try {
            Map<String, Object> article = articleFacade.getArticleById(id);

            if (article == null) {
                throw new WebApplicationException("Article with ID " + id + " not found", Response.Status.NOT_FOUND);
            }

            return Response.ok(article, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            throw new WebApplicationException("Failed to retrieve article", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
