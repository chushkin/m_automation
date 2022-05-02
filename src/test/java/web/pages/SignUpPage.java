package web.pages;

import com.codeborne.selenide.SelenideElement;
import rest.jsm.users.User;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage extends BasePage {

    protected SelenideElement userNameField = $("input[placeholder='Username']");
    protected SelenideElement emailField = $("input[placeholder='Email']");
    protected SelenideElement passwordField = $("input[placeholder='Password']");
    protected SelenideElement signInButton = $("button[type='submit']");

    public SignUpPage() {
        super("#/register");
    }

    public HomePage login(User user) {
        return login(user.getUsername(), user.getEmail(), user.getPassword());
    }

    public HomePage login(String userName, String email, String password) {
        userNameField.setValue(userName);
        emailField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
        return new HomePage();
    }
}
