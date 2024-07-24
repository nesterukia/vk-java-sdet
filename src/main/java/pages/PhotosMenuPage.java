package pages;

import com.codeborne.selenide.Condition;
import elements.LeftMenu;
import elements.TopMenu;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotosMenuPage extends BasePage implements LeftMenu, TopMenu {
    private By deletedPhotosTab = byXpath(".//*[@title='Удалённые фотографии']");
    private By createPhotoAlbumBtn = byXpath(".//*[@data-l='t,create-photo-album']");
    private By uploadFileBtn = byXpath(".//*[@data-l='t,upload-file']");
    private By uploadFileInput = byXpath(".//*[@data-l='t,upload-new-photo']/div/input");
    private By albumSearch = byXpath(".//input[@placeholder='Поиск по альбомам']");
    private By loadedFilePanel = byXpath(".//up-uploading-results");
    private By privatePhotosAlbum = byXpath(".//a[@title='Личные фотографии']");

    public PhotosMenuPage(){
        checkPage();
    }

    public void checkPage() {
        $(createPhotoAlbumBtn).shouldBe(visible.because("CreatePhotoAlbumBtn should be visible in PhotosMenuPage"), Duration.ofSeconds(1));
        $(uploadFileBtn).shouldBe(visible.because("UploadFileBtn should be visible in PhotosMenuPage"), Duration.ofSeconds(1));
        $(albumSearch).shouldBe(visible.because("AlbumSearch should be visible in PhotosMenuPage"), Duration.ofSeconds(1));
    }

    public DeletedPhotosPage openDeletedPhotosPage(){
        $(deletedPhotosTab)
                .shouldBe(visible.because("DeletedPhotosTab should be visible in PhotosMenuPage."))
                .click();
        return new DeletedPhotosPage();
    }

    public PhotosMenuPage uploadPic(File file){
        $(uploadFileInput)
                .should(exist.because("UploadFileInput should exist in PhotosMenuPage."), Duration.ofSeconds(1))
                .uploadFile(file);
        checkPicIsLoaded();
        return this;
    }

    public boolean loadedFilePanelIsVisible(){
        return $(loadedFilePanel).is(visible, Duration.ofSeconds(10));
    }
    public void checkPicIsLoaded(){
        $(loadedFilePanel).shouldBe(visible.because("LoadedFilePanel should be visible in PhotosMenuPage"), Duration.ofSeconds(10));
    }

    public PhotoAlbumPage openPrivatePhotosAlbum(){
        $(privatePhotosAlbum)
                .shouldBe(visible.because("PrivatePhotosAlbum should be visible in PhotosMenuPage."))
                .click();
        return new PhotoAlbumPage("Личные фотографии");
    }
}
