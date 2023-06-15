package facades;

import jakarta.persistence.*;
import jakarta.ws.rs.WebApplicationException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            Query query = em.createNativeQuery("SELECT id, title, opening, img_url, published, author, main_section\n" +
                    "FROM public.articles");
            List articleDTOSList = query.getResultList();
            if (articleDTOSList.isEmpty()) {
                throw new WebApplicationException("the database does not contain any items");
            }
            return articleDTOSList;
        }


    }

    public Map<String, Object> getArticleById(Long id) throws WebApplicationException {
        try (EntityManager em = emf.createEntityManager()) {
            Query query = em.createNativeQuery("SELECT id, title, opening, img_url, published, author, main_section FROM public.articles WHERE id = ?");
            query.setParameter(1, id);  // Bind the parameter by position

            Object result = query.getSingleResult();  // Cast the result to Object

            if (result == null) {
                throw new WebApplicationException("Article with ID " + id + " not found");
            }

            Object[] row = (Object[]) result;  // Cast the result to Object[]

            Map<String, Object> article = new HashMap<>();
            article.put("id", row[0]);
            article.put("title", row[1]);
            article.put("opening", row[2]);
            article.put("img_url", row[3]);
            article.put("published", row[4]);
            article.put("author", row[5]);
            article.put("main_section", row[6]);

            return article;
        }
    }




}
