package web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://react-redux.realworld.io/";
    }

    @BeforeEach
    public void openBrowser() {
        open(Configuration.baseUrl);
    }

    @AfterEach
    public void after() {
        Selenide.closeWebDriver();
    }

}
