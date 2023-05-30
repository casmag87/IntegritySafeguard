import entities.Role;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("john", "password");
    }

    @Test
    public void testGetUserName() {
        String expectedUserName = "john";
        String actualUserName = user.getUserName();
        Assertions.assertEquals(expectedUserName, actualUserName);
    }

    @Test
    public void testGetUserPass() {
        String expectedUserPass = "password";
        String actualUserPass = user.getUserPass();
        Assertions.assertTrue(BCrypt.checkpw(expectedUserPass, actualUserPass));
    }

    @Test
    public void testGetRoleList() {
        List<Role> expectedRoleList = new ArrayList<>();
        Role role = new Role("admin");
        expectedRoleList.add(role);
        user.addRole(role);
        List<Role> actualRoleList = user.getRoleList();
        Assertions.assertEquals(expectedRoleList, actualRoleList);
    }

    @Test
    public void testVerifyPassword() {
        String correctPassword = "password";
        String incorrectPassword = "wrongpassword";

        Assertions.assertTrue(user.verifyPassword(correctPassword));
        Assertions.assertFalse(user.verifyPassword(incorrectPassword));
    }

    @Test
    public void testToString() {
        String expectedString = "User{userName='john', userPass='password', roleList=[]}";
        String actualString = user.toString();
        Assertions.assertTrue(actualString.contains("userName='john'"));
        Assertions.assertTrue(actualString.contains("userPass='"));
        Assertions.assertTrue(actualString.contains("roleList=[]"));
    }
}