package tests;

import elements.LeftMenuOption;
import elements.PictureTypes;
import org.junit.jupiter.api.*;
import pages.*;


public class AddDescriptionToPhotoTest extends BaseTest {
    String newDescription = "Это ты на фотографии";
    PictureViewerPage pictureViewerPage;
    @BeforeEach
    public void init(){
        super.init();
        new LoginPage()
                .signInAs(VALID_USER.getLogin(), VALID_USER.getPassword())
                .openMenu(LeftMenuOption.PHOTOS);
        new PhotosMenuPage()
                .uploadPic(PictureTypes.JPG.getFile());
        new PhotosMenuPage()
                .openPrivatePhotosAlbum()
                .openLastPhoto();
        pictureViewerPage = new PictureViewerPage();
    }

    @Tag("PictureViewerComments")
    @DisplayName("AddDescriptionToPhotoTest")
    @Test
    public void addDescriptionToPhotoTest(){
        pictureViewerPage.addDescription(newDescription);
        pictureViewerPage.saveNewDesc();
        Assertions.assertEquals(pictureViewerPage.getDescription(),
                newDescription, "Displayed description should be equal to new description");
    }

    @AfterEach
    public void tearDown(){
        pictureViewerPage
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
