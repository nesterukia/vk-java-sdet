package pages;

import elements.LeftMenu;
import elements.TopMenu;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class GroupsMenuPage extends BasePage implements LeftMenu, TopMenu {

    private By searchInput = byXpath(".//*[@class='groups-catalog-header']//input[@type='search']");
    private By createGroupButton = byXpath(".//a[text()='Создать группу' and contains(@class, 'groups-catalog-header')]");
    private By userGroupsSearchResultList = byXpath(".//*[@id='userGroupsSearchResultList']");

    private By deleteSearchHistoryButton = byXpath(".//*[@class='groups-catalog-header']//button[contains(@class,'button-clean')]");

    public void checkPage(){
        $(searchInput).shouldBe(visible.because("SearchInput should be visible in GroupsMenuPage."));
        $(createGroupButton).shouldBe(visible.because("CreateGroupButton should be visible in GroupsMenuPage."));
    }

    public void searchGroup(String groupName){
        $(searchInput)
                .shouldBe(visible.because("SearchInput should be visible in GroupsMenuPage."))
                .click();
        sleep(100);
        $(searchInput)
                .shouldBe(visible.because("SearchInput should be visible in GroupsMenuPage."))
                .setValue(groupName)
                .shouldBe(visible.because("SearchInput should be visible before 'enter' is pressed."))
                .pressEnter();
    }
    public GroupPage openGroupPageFromSearch(String groupName){
        $(userGroupsSearchResultList)
                .find(byXpath(".//*[text()='"+groupName+"']"))
                .shouldBe(visible.because("GroupName should be visible during search."))
                .hover()
                .click();
        return new GroupPage();
    }

    public void clearLastSearch() {
        $(searchInput)
                .shouldBe(visible.because("SearchInput should be visible in GroupsMenuPage."))
                .click();
        $(deleteSearchHistoryButton)
                .shouldBe(visible.because("DeleteSearchHistoryButton should be visible in GroupsMenuPage after SearchInput click."))
                .click();
    }
}
