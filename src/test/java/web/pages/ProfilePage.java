package web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage extends BasePage{

    protected SelenideElement favoritedArticlesLink = $x("//a[contains(text(),'Favorited Articles')]");

    public ProfilePage() {
        super("#/");
    }

    public HomePage chooseFavoritedArticles(){
        favoritedArticlesLink.click();
        favoritedArticlesLink.shouldHave(Condition.cssClass("active"));
        return new HomePage();
    }
}
