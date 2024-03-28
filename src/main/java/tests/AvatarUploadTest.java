// Тест: Загрузка аватара в формате .wepg со страницы ленты

package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FeedPage;
import pages.LoginPage;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;

public class AvatarUploadTest extends BaseTest{
    private FeedPage feedPage;
    private File picWebp = new File("src/pics/cat.webp");

    @BeforeEach
    public void init(){
        super.init();

        // Вход в систему с валидным пользователем
        feedPage = new LoginPage().signInAs(VALID_USER.getLogin(), VALID_USER.getPassword());

        // Если есть аватар, то удаляем
        if(feedPage.avatarIsSet()){
            feedPage.openAvatar()
                    .deletePic()
                    .close();
        }
    }

    @Test
    public void photoUploadTest(){
        // Загружаем аватар из файла на компьютере
        feedPage.uploadAvatar(picWebp);

        // Проверяем что аватар виден
        feedPage.getAvatarPic()
                .shouldBe(visible);

    }

    @AfterEach
    public void tearDown(){
        // Удаляем аватар загруженный в тесте
        feedPage
                .openAvatar()
                .deletePic()
                .close();

        // Выходим из аккаунта
        feedPage.logOut();

        // Вызываем after-метод родителя
        super.tearDown();
    }
}
