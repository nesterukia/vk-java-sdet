package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.GroupsMenuPage;
import pages.PhotosMenuPage;
import pages.PictureViewerPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LeftMenu {
    private By rootLocator = byXpath(".//*[@area-label='Меню в левой колонке с разделами']");
    private By profilePictureLocator = byXpath(".//*[@id='viewImageLinkId']");
    private By profilePictureUploadInputLocator = byXpath(".//input[@name='photo']");
    private By userPageBtn = byXpath(".//a[contains(@data-l, 'userPage')]/div");
    private By photosPageBtn = byXpath(".//a[contains(@data-l, 'userPhotos')]/div");
    private By groupsPageBtn = byXpath(".//a[contains(@data-l, 'userAltGroup')]/div");

    public SelenideElement getRoot(){
        return $(rootLocator);
    }

    public SelenideElement getAvatarPic(){
        return $(profilePictureLocator);
    }

    public PictureViewerPage openAvatar(){
        $(profilePictureLocator)
                .shouldBe(visible)
                .click();
        return new PictureViewerPage();
    }

    public void uploadProfilePicture(File pic){
        By setButtonLocator = byXpath(".//*[text()='Установить']");

        $(profilePictureUploadInputLocator).uploadFile(pic);
        $(setButtonLocator)
                .shouldBe(visible.because("SetButton should be visible when picture is uploaded."))
                .click();
    }

    public GroupsMenuPage openGroupsMenu(){
        $(groupsPageBtn)
                .shouldBe(visible.because("UserGroupsButton should be visible in LeftMenu"))
                .click();
        return new GroupsMenuPage();
    }

    public boolean avatarIsSet(){
        return $(profilePictureLocator).exists();
    }

    public PhotosMenuPage openPhotosMenu() {
        $(photosPageBtn)
                .shouldBe(visible.because("UserPhotosButton should be visible in LeftMenu"))
                .click();
        return new PhotosMenuPage();
    }

    public String getUserCreds(){
        String userCreds = $(userPageBtn)
                .shouldBe(visible.because("UserPageButton should be visible in LeftMenu"))
                .getText();
        return userCreds;
    }
}
