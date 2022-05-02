package web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ArticlePage extends BasePage {

    protected SelenideElement articleTitle = $(".container>h1");
    protected SelenideElement articleContent = $(".article-content p");

    public ArticlePage() {
        super("#/article");
    }

    public String getArticleTitle(){
        return articleTitle.getText();
    }

    public String getArticleDescription(){
        return articleContent.getText();
    }

}
