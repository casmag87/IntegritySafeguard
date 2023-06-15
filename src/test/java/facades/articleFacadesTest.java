package facades;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.ws.rs.WebApplicationException;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.*;

public class articleFacadesTest {


    private static EntityManagerFactory emf;
    private static ArticleFacade facade;

    @BeforeAll
    public static void beforeAll(){
        emf = Persistence.createEntityManagerFactory("puTest");
        facade = facade.getFacade(emf);
    }

    @AfterAll
    public static void tearDownClass(){

    }



    @BeforeEach
    public void setUP(){


    }

    @AfterEach
    public void tearDown(){
    }

    @Test
    public void testGetFacade() {

        assertNotNull(facade.getFacade(emf));
        assertSame(facade.getFacade(emf), facade.getFacade(emf));
    }

    @Test
    public void testGetAllArticles(){
        List list= facade.getAllObjects();
        assertTrue(list.size()>20);
    }
    @Test
    public void testGetArticleById() throws SQLException {
        Long articleId = 1L;

        Map<String, Object> actualArticle = facade.getArticleById(articleId);

        // Verify the attributes of the article retrieved from the database
        Assertions.assertEquals(articleId.intValue(), ((Number) actualArticle.get("id")).longValue());
        Assertions.assertEquals("Consolidate Vendors and Products for Better Security", actualArticle.get("title"));
        Assertions.assertEquals("Instead of deploying new point products, CISOs should consider sourcing technologies from vendors that develop products designed to work together as part of a platform. ", actualArticle.get("opening"));
        Assertions.assertEquals("", actualArticle.get("img_url"));
        Assertions.assertEquals("June 8, 2023", actualArticle.get("published"));
        Assertions.assertEquals("John Maddison", actualArticle.get("author"));

    }

}
