package web.pages;

public abstract class BasePage {
    protected static final String BASE_URL = "https://react-redux.realworld.io/";
    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = BASE_URL + pageUrl;
    }
}
