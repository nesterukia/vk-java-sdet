package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage {
    private SelenideElement loginField = $(byXpath("//*[@id=\"field_email\"]"));
    private SelenideElement passwordField = $(byXpath("//*[@id=\"field_password\"]"));
    private SelenideElement signInButton = $(byValue("Войти в Одноклассники"));

    public LoginPage(){
    }
    public LoginPage typeLogin(String login){
        loginField.setValue(login);
        return this;
    }
    public LoginPage typePassword(String password){
        passwordField.setValue(password);
        return this;
    }
    public FeedPage submitSignIn(){
        signInButton.click();
        return new FeedPage();
    }

    public FeedPage signInAs(String login, String password){
        return typeLogin(login)
                .typePassword(password)
                .submitSignIn();
    }
}
