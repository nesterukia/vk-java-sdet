package pages;

import com.codeborne.selenide.SelenideElement;
import elements.LeftMenu;
import elements.TopMenu;

import java.io.File;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

abstract public class BasePage {
    protected TopMenu topMenu = new TopMenu();
    protected LeftMenu leftMenu = new LeftMenu();

    public SelenideElement getTopMenu() {
        return topMenu.getRoot();
    }
    public SelenideElement getLeftMenu(){
        return leftMenu.getRoot();
    }

    public SelenideElement getAvatarPic() {
        return leftMenu.getAvatarPic();
    }

    public PictureViewerPage openAvatar(){
        return leftMenu.openAvatar();
    }

    public LoginPage logOut(){
        return topMenu.logOut();
    }
    public void uploadProfilePicture(File pic){
        leftMenu.uploadProfilePicture(pic);
    }
    public boolean avatarIsSet(){
        return leftMenu.avatarIsSet();
    }
    public GroupsMenuPage openGroupsMenu(){
        return leftMenu.openGroupsMenu();
    }
    public PhotosMenuPage openPhotosMenu(){
        return leftMenu.openPhotosMenu();
    }

    public String getUserCreds(){
        return leftMenu.getUserCreds();
    }
}
