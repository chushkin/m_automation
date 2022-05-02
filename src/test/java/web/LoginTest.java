package web;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.jsm.users.User;
import utils.UserGeneratorUtils;
import web.pages.HomePage;


public class LoginTest extends BaseTest{

    @Test
    public void testSignUp() {
        User user = UserGeneratorUtils.getRandomUser();
        Assertions.assertTrue(new HomePage().getSignUpPage().login(user).isLogged(), "User haven't registered");
    }

    @Test
    public void testLogin() {

    }

    @AfterEach
    public void after() {
        Selenide.closeWebDriver();
    }

}
