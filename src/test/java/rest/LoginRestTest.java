package rest;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import rest.jsm.users.UserRequest;
import utils.RestWrapper;
import utils.UserGeneratorUtils;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginRestTest {

    UserRequest user;

    @BeforeEach
    public void initEach(){
        System.out.println("BeforeEach");
        user = UserRequest.builder()
                .user(UserGeneratorUtils.getRandomUser())
                .build();
    }
    @Test
    public void login() {
        System.out.println("st test");
        /*UserRequest user = UserRequest.builder()
                .user(UserGeneratorUtils.getRandomUser())
                .build();*/
        given()
                .contentType(ContentType.JSON)
                .baseUri(RestWrapper.BASE_URL)
                .basePath("/users")
                .body(user)
                .log().all()
                .post().jsonPath();
       // Assert.assertEquals("", "fdfdfd");
        assertEquals(42, Integer.sum(19, 23));
        System.out.println("end test");
    }

    @Test
    public void getUsers() {
        given()
                .contentType(ContentType.JSON)
                .baseUri(RestWrapper.BASE_URL)
                .basePath("/users")
                .body("")
                .log().all()
                .post().jsonPath();
        when().post();
       // Assert.assertEquals("", "fdfdfd");
    }
}
