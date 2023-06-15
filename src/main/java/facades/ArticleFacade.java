package rest.facades;

import jakarta.persistence.*;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

public class ArticleFacade  {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("puTest");;
    private static ArticleFacade instance;


    public static ArticleFacade getFacade(EntityManagerFactory _emf) {

        if (instance == null) {
            emf = _emf;
            instance = new ArticleFacade();
        }
        return instance;

    }



    public List getAllObjects() throws WebApplicationException {
        try (EntityManager em = emf.createEntityManager()) {
            Query query = em.createNativeQuery("SELECT * FROM articles");
            List articleDTOSList = query.getResultList();
            if (articleDTOSList.isEmpty()) {
                throw new WebApplicationException("the database does not contain any items");
            }
            return articleDTOSList;
        }


    }





}
