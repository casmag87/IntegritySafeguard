package entities;

import entities.Bookmark;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class BookmarkTest {

    private Bookmark bookmark;

    @BeforeEach
    public void setup() {
        bookmark = new Bookmark();
        bookmark.setId(1L);
        bookmark.setTitle("Sample Article");
        bookmark.setImgUrl("https://example.com/image.jpg");
        bookmark.setDescription("This is a sample article.");
        bookmark.setCreatedOn(new Date());
        bookmark.setUser(new User("john"));
    }

    @Test
    public void testGetId() {
        Long expectedId = 1L;
        Long actualId = bookmark.getId();
        Assertions.assertEquals(expectedId, actualId);
    }

    @Test
    public void testGetTitle() {
        String expectedTitle = "Sample Article";
        String actualTitle = bookmark.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void testGetImgUrl() {
        String expectedImgUrl = "https://example.com/image.jpg";
        String actualImgUrl = bookmark.getImgUrl();
        Assertions.assertEquals(expectedImgUrl, actualImgUrl);
    }

    @Test
    public void testGetDescription() {
        String expectedDescription = "This is a sample article.";
        String actualDescription = bookmark.getDescription();
        Assertions.assertEquals(expectedDescription, actualDescription);
    }

    @Test
    public void testGetCreatedOn() {
        Date expectedCreatedOn = new Date(); // Get the current date and time
        Date actualCreatedOn = bookmark.getCreatedOn();

        long expectedTime = expectedCreatedOn.getTime();
        long actualTime = actualCreatedOn.getTime();
        long tolerance = 100; // Tolerance in milliseconds

        Assertions.assertTrue(Math.abs(expectedTime - actualTime) <= tolerance);
        Assertions.assertEquals(expectedTime, actualTime, tolerance);

    }

    @Test
    public void testGetUser() {
        User expectedUser = new User("john");
        User actualUser = bookmark.getUser();

        // Compare individual properties of the User objects
        Assertions.assertEquals(expectedUser.getUserName(), actualUser.getUserName());
        Assertions.assertEquals(expectedUser.getUserPass(), actualUser.getUserPass());
        Assertions.assertEquals(expectedUser.getRoleList(), actualUser.getRoleList());
    }
}
