// Тест: Загрузка аватара в формате .wepg со страницы ленты при отсутствии фотографий в альбомах

package tests;

import elements.LeftMenuOption;
import org.junit.jupiter.api.*;
import pages.DeletedPhotosPage;
import pages.FeedPage;
import pages.LoginPage;
import pages.PhotosMenuPage;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProfilePictureUploadTest extends BaseTest{
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
    @Tag("photos")
    @DisplayName("ProfilePictureUploadTest")
    public void profilePictureUploadTest(){
        // Загружаем аватар из файла на компьютере
        feedPage.uploadProfilePicture(picWebp);

        // Проверяем что аватар виден
        assertNotNull(feedPage.getAvatarPic(), "Profile picture element should be visible.");
    }

    @AfterEach
    public void tearDown(){
        // Удаляем аватар загруженный в тесте
        feedPage
                .openAvatar()
                .deletePic()
                .close();

        // Чистим удаленные фотографии
        new FeedPage().openMenu(LeftMenuOption.PHOTOS);
        PhotosMenuPage photosMenuPage = new PhotosMenuPage();
        DeletedPhotosPage deletedPhotosPage = photosMenuPage.openDeletedPhotosPage();
        deletedPhotosPage.clearLastDeletedPhoto();

        // Выходим из аккаунта
        deletedPhotosPage
                .logOut();
        // Вызываем after-метод родителя
        super.tearDown();
    }
}
