package tests;

import org.junit.jupiter.api.*;
import pages.GroupPage;
import pages.GroupsMenuPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupSubscriptionFromSearchTest extends BaseTest{
    private GroupsMenuPage groupsMenuPage;
    private GroupPage groupPage;
    private final String GROUP_FOR_SEARCH = "Санкт-Петербургский политехнический университет";
    @BeforeEach
    public void init(){
        super.init();
        new LoginPage().signInAs(VALID_USER.getLogin(), VALID_USER.getPassword());
        open("/groups");
    }

    @RepeatedTest(value = 2, name = "Test {displayName} Number {currentRepetition}/{totalRepetitions}")
    @Tag("GroupsTest")
    @DisplayName("GroupSubscriptionFromSearchTest.")
    public void groupSubscriptionFromSearchTest(){
        groupsMenuPage = new GroupsMenuPage();
        groupsMenuPage.searchGroup(GROUP_FOR_SEARCH);
        groupPage = groupsMenuPage.openGroupPageFromSearch(GROUP_FOR_SEARCH);
        groupPage.follow();
        assertTrue(groupPage.isFollowed(), "MessageButton should be visible after subscription.");
    }
    @AfterEach
    public void tearDown(){
        refresh();
        groupPage = new GroupPage();
        groupPage.unfollow();
        open("/groups");
        groupsMenuPage = new GroupsMenuPage();
        groupsMenuPage.clearLastSearch();
        groupsMenuPage.logOut();
        // Выходим из аккаунта
        super.tearDown();
    }
}
