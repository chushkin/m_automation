package web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.jsm.users.User;
import utils.UserGeneratorUtils;
import web.pages.HomePage;

import java.util.List;

public class ArticleTest extends BaseTest{

    private User user = UserGeneratorUtils.getRandomUser();
    private int first = 0;
    private HomePage homePage;

    @BeforeEach
    public void before(){
        homePage = new HomePage();
    }

    @Test
    public void testAddArticleToFavourites(){
        String firstTitle = homePage.getSignUpPage().login(user).chooseGlobalFeed().getTitleList().get(first);
        homePage.addArticleToFavouriteByTitle(firstTitle);
        List<String> favoritedTitles = homePage.getProfilePage().chooseFavoritedArticles().getTitleList();
        Assertions.assertTrue(favoritedTitles.contains(firstTitle));
    }

}
