package web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rest.jsm.posts.Article;
import rest.jsm.users.User;
import utils.UserGeneratorUtils;
import web.pages.HomePage;

import static utils.ArticleGeneratorUtils.getRandomArticle;

public class NewPostTest extends BaseTest{

    private User user;
    private Article article;

    @BeforeEach
    public void before() {
        user = UserGeneratorUtils.getRandomUser();
        article = getRandomArticle();
    }

    @Test
    public void testAddNewPost() {
        String articleTitle = new HomePage()
                .getSignUpPage()
                .login(user)
                .getNewPostPage()
                .publishNewPost(article)
                .getArticleTitle();
        Assertions.assertEquals(article.getTitle(), articleTitle, "User haven't registered");
    }

    @Test
    public void testDescriptionPost() {
        Assertions.assertEquals(article.getDescription(),
                new HomePage()
                        .getSignUpPage()
                        .login(user)
                        .getNewPostPage()
                        .publishNewPost("wwsw", article.getDescription(), article.getDescription(), "sdsddsd")
                        .getArticleDescription(),
                "User haven't registered");
    }

}
