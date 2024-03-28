package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupsMenuPage extends BasePage{
    private SelenideElement searchField = $(byXpath("//*[@id=\"hook_Block_UserGroupSearch2QueryBlock\"]/group-search-input/div/div/div/label/input"));
    private SelenideElement searchPortal = $(byXpath("//*[@id=\"hook_Block_UserGroupsSearchPortal\"]/div"));
    private SelenideElement myGroups = $(byXpath("//*[@id=\"hook_Block_MyGroupsTopBlock\"]/div/div[1]/h3/a"));
    public ElementsCollection searchGroup(String groupName){
        String groupCardLocator = "#hook_Loader_UserGroupsSearchPortalLoader > div:nth-child(1)";
        //SelenideElement searchBtn
        searchField
                .setValue(groupName)
                .click();
        searchField
                .pressEnter();

        return searchPortal.findAll(groupCardLocator);
    }
    public GroupPage openGroupPageFromSearch(ElementsCollection results, String groupName){
        SelenideElement groupToOpen = results.findBy(text(groupName));
        groupToOpen
                .shouldBe(visible)
                .find(byText(groupName))
                .click();
        return new GroupPage();
    }

    public GroupsMenuPage openMyGroupsSection(){
        myGroups.click();
        return this;
    }

    public GroupPage openMyGroup(String groupName){
        openMyGroupsSection();
        SelenideElement groupImage = $("img[alt='"+ groupName+"']");
        groupImage.click();
        return new GroupPage();
    }
}
