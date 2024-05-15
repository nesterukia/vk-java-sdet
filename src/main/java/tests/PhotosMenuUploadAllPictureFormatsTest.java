package tests;

import elements.LeftMenuOption;
import elements.PictureTypes;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.*;

import static com.codeborne.selenide.Selenide.*;

public class PhotosMenuUploadAllPictureFormatsTest extends BaseTest{
    PhotosMenuPage photosMenuPage;
    @BeforeEach
    public void init(){
        super.init();
        FeedPage feedPage = new LoginPage()
                .typeLogin(VALID_USER.getLogin())
                .typePassword(VALID_USER.getPassword())
                .submitSignIn();
        feedPage.openMenu(LeftMenuOption.PHOTOS);
    }
    @EnumSource(PictureTypes.class)
    @ParameterizedTest(name = "Every image type check")
    @Tag("photos")
    public void photosMenuUploadAllPictureFormatsTest(PictureTypes pic){
        photosMenuPage = new PhotosMenuPage();
        photosMenuPage.uploadPic(pic.getFile());
        Assertions.assertTrue(photosMenuPage.loadedFilePanelIsVisible(), "LoadedPanel should be visible after subscription.");
    }
    @AfterEach
    public void tearDown(){
        refresh();
        new PhotosMenuPage()
                .openPrivatePhotosAlbum()
                .openLastPhoto()
                .deletePic()
                .close();
        new PhotoAlbumPage()
                .goBackToPhotosMenuPage()
                .openDeletedPhotosPage()
                .clearLastDeletedPhoto();
        new DeletedPhotosPage().logOut();
        super.tearDown();
    }
}
