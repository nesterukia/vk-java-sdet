// Тест: Загрузка аватара в формате .wepg со страницы ленты при отсутствии фотографий в альбомах

package tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DeletedPhotosPage;
import pages.FeedPage;
import pages.LoginPage;
import pages.PhotosMenuPage;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        assertNotNull(feedPage.getAvatarPic());
    }

    @AfterEach
    public void tearDown(){
        // Удаляем аватар загруженный в тесте
        feedPage
                .openAvatar()
                .deletePic()
                .close();

        // Чистим удаленные фотографии
        PhotosMenuPage photosMenuPage = new FeedPage().openPhotosMenu();
        DeletedPhotosPage deletedPhotosPage = photosMenuPage.openDeletedPhotosPage();
        deletedPhotosPage.clearLastDeletedPhoto();

        // Выходим из аккаунта
        deletedPhotosPage
                .logOut();
        // Вызываем after-метод родителя
        super.tearDown();
    }
}
