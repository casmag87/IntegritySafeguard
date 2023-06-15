package rest;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import jakarta.persistence.EntityManagerFactory;
import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javax.ws.rs.core.Application;
import java.net.URI;

import static io.restassured.RestAssured.given;

public class ArticleResourseTest {

    private static final int SERVER_PORT = 7777;
    private static String SERVER_URL = "http://localhost/api";

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();

    private static HttpServer httpServer;
    private static EntityManagerFactory emf;


    static org.glassfish.grizzly.http.server.HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        //This method must be called before you request the EntityManagerFactory


        httpServer = startServer();
        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {


        httpServer.shutdownNow();
    }

    @Test
    public void testServerIsUP(){

        given().when().get("/article").then().statusCode(200);

    }


}
