package tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GroupPage;
import pages.GroupsMenuPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GroupsTest extends BaseTest{

    private GroupsMenuPage groups = new GroupsMenuPage();
    private String groupToFind = "Санкт-Петербургский политехнический университет";
    private SelenideElement groupImage= $("img[alt='"+ groupToFind+"']");
    @BeforeEach
    public void init(){
        super.init();
        new LoginPage().signInAs(VALID_USER.getLogin(), VALID_USER.getPassword());
        open("/groups");
    }

    @Test
    public void groupsTest(){

        ElementsCollection searchResults = groups.searchGroup(groupToFind);
        GroupPage groupPage = groups.openGroupPageFromSearch(searchResults, groupToFind);
        groupPage.follow();

        groups = groupPage.openGroupsMenu();
        groups.openMyGroupsSection();
        groupImage.shouldBe(visible);

    }

    @AfterEach
    public void tearDown(){
        // Отписаться от группы
        open("/groups");
        groups
                .openMyGroupsSection()
                        .openMyGroup(groupToFind)
                                .unfollow();
        groups.logOut();
        super.tearDown();
    }
}
