package entities;

import DTO.ArticleDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArticleTest {

    private ArticleDTO article;


    @BeforeEach
    public void setup(){
        article = new ArticleDTO();
        article.setId(1L);
        article.setTitle("Sample Article");
        article.setOpening("this is a sample article");
        article.setImgUrl("https://example.com/image.jpg");
        article.setMainSection("This is a sample article");
    }

    @AfterEach
    public void cleanup() {
        article = null;
    }

    @Test
    public void testGetId(){
        Long expectedId = 1L;
        Long actualId = article.getId();
        Assertions.assertEquals(expectedId,actualId);
    }

    @Test
    public void testGetTitle() {
        String expectedTitle = "Sample Article";
        String actualTitle = article.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testGetImgUrl() {
        String expectedImgUrl = "https://example.com/image.jpg";
        String actualImgUrl = article.getImgUrl();
        Assertions.assertEquals(expectedImgUrl, actualImgUrl);
    }

    @Test
    public void testGetOpening(){
        String expectedOpening = "this is a sample article";
        String actualOpening = article.getOpening();
        Assertions.assertEquals(expectedOpening, actualOpening);
    }

    @Test
    public void voidGetMainSection(){
        String expectedMain = "This is a sample article";
        String actualMain = article.getMainSection();
        Assertions.assertEquals(expectedMain, actualMain);


    }

}
