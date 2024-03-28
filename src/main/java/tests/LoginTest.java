package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.visible;


public class LoginTest extends BaseTest{
    LoginPage loginPage = new LoginPage();
    FeedPage feedPage;

    @Test
    public void validLoginTest(){
        feedPage = loginPage.signInAs(VALID_USER.getLogin(), VALID_USER.getPassword());
        feedPage.getLeftMenu().shouldBe(visible);
        feedPage.getTopMenu().shouldBe(visible);
    }

    @AfterEach
    public void tearDown(){
        feedPage.logOut();
        super.tearDown();
    }
}

