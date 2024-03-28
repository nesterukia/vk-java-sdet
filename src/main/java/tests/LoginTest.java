// Тест: Вход в аккаунт через валидные логин и пароль
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
        // Производим логин с логином и паролем валидного пользователя
        feedPage = loginPage.signInAs(VALID_USER.getLogin(), VALID_USER.getPassword());

        // Проверяем отображение левого меню-навигации и верхнего меню-навигации
        feedPage.getLeftMenu().shouldBe(visible);
        feedPage.getTopMenu().shouldBe(visible);
    }

    @AfterEach
    public void tearDown(){
        // Выходим из аккаунта
        feedPage.logOut();
        super.tearDown();
    }
}

