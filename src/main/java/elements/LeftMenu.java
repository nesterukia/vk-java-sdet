package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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
    private SelenideElement root = $(byXpath("//*[@id=\"layout-container\"]/aside/nav"));
    private SelenideElement avatarPic = $(byXpath("//*[@id=\"viewImageLinkId\"]"));
    private SelenideElement avatarUploadInput = $(byXpath("//*[@id=\"hook_Block_Avatar\"]/div/div/span/input"));

    private ElementsCollection navigationBtns = $$("div[class='nav-side_i-w']");

    public SelenideElement getRoot(){
        return root;
    }

    public SelenideElement getAvatarPic(){
        return avatarPic;
    }

    public PictureViewerPage openAvatar(){
        avatarPic
                .shouldBe(visible)
                .click();
        return new PictureViewerPage();
    }

    public void uploadAvatar(File pic){
        avatarUploadInput.uploadFile(pic);
        SelenideElement confirmBtn = $(byXpath("//*[@id=\"hook_Block_PopLayer\"]/div/change-user-avatar/div/div/div[2]/div[1]/div[3]/button[1]/span/span[1]"));
        confirmBtn.shouldBe(visible).click();
    }

    public GroupsMenuPage openGroupsMenu(){
        SelenideElement groupBtn = navigationBtns.findBy(text("Группы"));
        groupBtn.click();
        return new GroupsMenuPage();
    }

    public boolean avatarIsSet(){
        return avatarPic.exists();
    }

    public PhotosMenuPage openPhotosMenu() {
        SelenideElement photosBtn = navigationBtns.findBy(text("Фото"));
        photosBtn.click();
        return new PhotosMenuPage();
    }
}
