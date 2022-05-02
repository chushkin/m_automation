package web.pages;

import com.codeborne.selenide.SelenideElement;
import rest.jsm.posts.Article;

import static com.codeborne.selenide.Selenide.$;

public class NewPostPage extends BasePage{

    protected SelenideElement articleTitleField = $("input[placeholder='Article Title']");
    protected SelenideElement articleDescriptionField = $("input[placeholder=\"What's this article about?\"]");
    protected SelenideElement articleBodyField = $("textarea[placeholder='Write your article (in markdown)']");
    protected SelenideElement tagsField = $("input[placeholder='Enter tags']");
    protected SelenideElement publishArticleButton = $("button[type='button']");

    public NewPostPage() {
        super("#/editor");
    }


    public ArticlePage publishNewPost(Article article){
        return publishNewPost(article.getTitle(), article.getDescription(), article.getBody(), article.getTagList());
    }


    public ArticlePage publishNewPost(String articleTitle, String articleDescription, String articleBody, String tags){
        articleTitleField.setValue(articleTitle);
        articleDescriptionField.setValue(articleDescription);
        articleBodyField.setValue(articleBody);
        tagsField.setValue(tags);
        publishArticleButton.click();
        return new ArticlePage();
    }
}
