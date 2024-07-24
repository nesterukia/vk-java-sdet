package elements;

import pages.BasePage;
import pages.FeedPage;
import pages.GroupsMenuPage;
import pages.PhotosMenuPage;

public enum LeftMenuOption {
        PROFILE("t,userPage", "UserProfileBtn"),
    FEED("t,userMain", "UserFeedButton"),
    HOBBY("t,hobby", "UserHobbyButton"),
    FRIENDS("t,userFriend", "UserFriendsButton"),
    PHOTOS("t,userPhotos", "UserPhotosButton"),
    GROUPS("t,userAltGroup", "UserGroupsButton"),
    VITRINE("t,appsShowcaseHD", "UserGamesButton"),
    GIFTS("t,giftsFront", "UserGiftsButton"),
    DISCOVERY("t,discovery", "UserDiscoveryButton"),
    SERVICES("t,bizApps", "UserServicesButton"),
    DATING("t,appsDating", "UserDatingButton");

    private String data_l;
    private String name;
    private BasePage page;

    LeftMenuOption(String data_l, String name) {
        this.data_l = data_l;
        this.name = name;
    }
    LeftMenuOption(String data_l, String name, BasePage page) {
        this.data_l = data_l;
        this.name = name;
        this.page = page;
    }

    public String getData_l() {
        return data_l;
    }

    public String getName() {
        return name;
    }

    public BasePage getPage(){
        return page;
    }
}
