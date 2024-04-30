package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.GroupsMenuPage;
import pages.PhotosMenuPage;
import pages.PictureViewerPage;
import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface LeftMenu {
    By profilePictureLocator = byXpath(".//*[@id='viewImageLinkId']");
    By profilePictureUploadInputLocator = byXpath(".//input[@name='photo']");
    By userPageBtn = byXpath(".//a[contains(@data-l, 'userPage')]/div");
    By photosPageBtn = byXpath(".//a[contains(@data-l, 'userPhotos')]/div");
    By groupsPageBtn = byXpath(".//a[contains(@data-l, 'userAltGroup')]/div");

    default SelenideElement getAvatarPic(){
        return $(profilePictureLocator);
    }

    default PictureViewerPage openAvatar(){
        $(profilePictureLocator)
                .shouldBe(visible)
                .click();
        return new PictureViewerPage();
    }

    default void uploadProfilePicture(File pic){
        By setButtonLocator = byXpath(".//*[text()='Установить']");

        $(profilePictureUploadInputLocator).uploadFile(pic);
        $(setButtonLocator)
                .shouldBe(visible.because("SetButton should be visible when picture is uploaded."))
                .click();
    }

    default GroupsMenuPage openGroupsMenu(){
        $(groupsPageBtn)
                .shouldBe(visible.because("UserGroupsButton should be visible in LeftMenu"))
                .click();
        return new GroupsMenuPage();
    }

    default boolean avatarIsSet(){
        return $(profilePictureLocator).exists();
    }

    default PhotosMenuPage openPhotosMenu() {
        $(photosPageBtn)
                .shouldBe(visible.because("UserPhotosButton should be visible in LeftMenu"))
                .click();
        return new PhotosMenuPage();
    }

    default String getUserCreds(){
        String userCreds = $(userPageBtn)
                .shouldBe(visible.because("UserPageButton should be visible in LeftMenu"))
                .getText();
        return userCreds;
    }
}
