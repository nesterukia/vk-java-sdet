package pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage extends BasePage{
    private By loginField = byXpath(".//*[@id='field_email']");
    private By passwordField = byXpath(".//*[@id='field_password']");
    private By signInButton = byXpath(".//input[@value='Войти в Одноклассники']");

//    public LoginPage(){
//        checkPage();
//    }
    @Override
    public void checkPage(){
        $(loginField).shouldBe(visible.because("LoginField should be visible in LoginPage"), Duration.ofSeconds(1));
        $(passwordField).shouldBe(visible.because("PasswordField should be visible in LoginPage"), Duration.ofSeconds(1));
        $(signInButton).shouldBe(visible.because("SignInButton should be visible in LoginPage"), Duration.ofSeconds(1));
    }
    public LoginPage typeLogin(String login){
        $(loginField)
                .shouldBe(visible.because("LoginField should be visible in LoginPage"))
                .setValue(login);
        return this;
    }
    public LoginPage typePassword(String password){
        $(passwordField)
                .shouldBe(visible.because("PasswordField should be visible in LoginPage"))
                .setValue(password);
        return this;
    }
    public FeedPage submitSignIn(){
        $(signInButton)
                .shouldBe(visible.because("SignInButton should be visible in LoginPage"))
                .click();
        return new FeedPage();
    }

    public FeedPage signInAs(String login, String password){
        return typeLogin(login)
                .typePassword(password)
                .submitSignIn();
    }
}
