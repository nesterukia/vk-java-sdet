package pages;

import elements.LeftMenu;
import elements.TopMenu;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotoAlbumPage extends BasePage implements LeftMenu, TopMenu {
    private By lastPhotoCard = byXpath(".//*[contains(@class, 'photo-card')]");
    private By uploadFileBtn = byXpath(".//*[@data-l='t,upload-file']");
    private By uploadFileInput = byXpath(".//*[@data-l='t,upload-new-photo']/div/input");
    private By albumHeaderTitle = byXpath(".//*[contains(@class, 'portlet_h_part')]");
    private By photosMenuBreadCrumb = byXpath(".//*[@data-l='t,root']");
    private String albumName;


    public PhotoAlbumPage(){
        checkPage();
    }
    public PhotoAlbumPage(String albumName){
        this.albumName = albumName;
        checkPage();
    }
    public void checkPage() {
        $(uploadFileBtn).shouldBe(visible.because("UploadFileBtn should be visible in PhotoAlbumPage."), Duration.ofSeconds(1));
        $(albumHeaderTitle).shouldBe(visible.because("AlbumHeaderTitle should be visible in PhotoAlbumPage."), Duration.ofSeconds(1));
    }
    public String getAlbumName(){
        return albumName;
    }

    public PictureViewerPage openLastPhoto(){
        $(lastPhotoCard)
                .shouldBe(visible.because("LastPhotosCard should be visible in PhotoAlbumPage"))
                .click();
        return new PictureViewerPage();
    }

    public PhotosMenuPage goBackToPhotosMenuPage(){
        $(photosMenuBreadCrumb).shouldBe(visible.because("PhotosMenuBreadCrumb should be visible in PhotoAlbumPage."), Duration.ofSeconds(1))
                .click();
        return new PhotosMenuPage();
    }
}
