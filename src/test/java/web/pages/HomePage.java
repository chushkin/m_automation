package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage{

    protected SelenideElement registerLink = $("a[href='#register']");
    protected SelenideElement userLink = $(".user-pic");
    protected SelenideElement newPostLink = $("a[href='#editor']");
    protected SelenideElement globalFeedLink = $x("//a[contains(text(),'Global Feed')]");
    protected List<SelenideElement> titleList = $$("div.article-preview h1");
    protected List<SelenideElement> articleList = $$("div.article-preview");

    public HomePage() {
        super("");
    }
    public HomePage(String pageUrl) {
        super(pageUrl);
    }

    public SignUpPage getSignUpPage(){
        registerLink.click();
        return new SignUpPage();
    }

    public NewPostPage getNewPostPage(){
        newPostLink.click();
        return new NewPostPage();
    }

    public ProfilePage getProfilePage(){
        userLink.click();
        return new ProfilePage();
    }

    public Boolean isLogged(){
        userLink.should(Condition.visible);
        return userLink.shouldBe(Condition.visible).is(Condition.visible);
    }

    public HomePage chooseGlobalFeed(){
        globalFeedLink.click();
        globalFeedLink.shouldHave(Condition.cssClass("active"));
        return this;
    }

    public List<String> getTitleList(){
      return titleList.stream().map(SelenideElement::getText).toList();
    }

    public HomePage addArticleToFavouriteByTitle(String title){
        getArticleByTitle(title).$("button").click();
        return this;
    }

    private SelenideElement getArticleByTitle(String title){
        return articleList.stream().filter(article -> article.$("h1").getText().equalsIgnoreCase(title)).findFirst().get();
    }

}
