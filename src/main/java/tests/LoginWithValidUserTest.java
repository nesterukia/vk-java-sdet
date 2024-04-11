// Тест: Вход в аккаунт через валидные логин и пароль
package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginWithValidUserTest extends BaseTest{
    LoginPage loginPage;
    FeedPage feedPage;

    @Test
    @Tag("LoginTest")
    @DisplayName("LoginWithValidUserTest.")
    public void loginWithValidUserTest(){
        loginPage = new LoginPage();
        // Производим логин с логином и паролем валидного пользователя
        feedPage = loginPage.signInAs(VALID_USER.getLogin(), VALID_USER.getPassword());

        // Проверяем что имя и фамилия пользователя совпадают с исходными
        assertEquals(feedPage.getUserCreds(), VALID_USER.getCreds(), "User creds should be equal to VALID_USER creds.");
    }

    @AfterEach
    public void tearDown(){
        // Выходим из аккаунта
        feedPage.logOut();
        super.tearDown();
    }
}

