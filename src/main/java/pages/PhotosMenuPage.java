package pages;

import elements.LeftMenu;
import elements.TopMenu;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotosMenuPage extends BasePage implements LeftMenu, TopMenu {
    private By deletedPhotosTab = byXpath(".//*[@title='Удалённые фотографии']");
    private By createPhotoAlbumBtn = byXpath(".//*[@data-l='t,create-photo-album']");
    private By uploadFileBtn = byXpath(".//*[@data-l='t,upload-file']");
    private By albumSearch = byXpath(".//input[@placeholder='Поиск по альбомам']");

    public PhotosMenuPage(){
        checkPage();
    }
    @Override
    public void checkPage() {
        $(createPhotoAlbumBtn).shouldBe(visible.because("CreatePhotoAlbumBtn should be visible in PhotosMenuPage"));
        $(uploadFileBtn).shouldBe(visible.because("UploadFileBtn should be visible in PhotosMenuPage"));
        $(albumSearch).shouldBe(visible.because("AlbumSearch should be visible in PhotosMenuPage"));
    }

    public DeletedPhotosPage openDeletedPhotosPage(){
        $(deletedPhotosTab)
                .shouldBe(visible.because("DeletedPhotosTab should be visible in PhotosMenuPage."))
                .click();
        return new DeletedPhotosPage();
    }
}
