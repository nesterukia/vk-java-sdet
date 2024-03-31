package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupsMenuPage extends BasePage{
    private SelenideElement searchInput = $(byXpath(".//input[@type='search']"));
    private SelenideElement searchPortal = $(byXpath(".//*[@id='userGroupsSearchResultList']"));
    private SelenideElement myGroups = $(byXpath(".//a[text()='Мои группы']"));
    public ElementsCollection searchGroup(String groupName){
        //SelenideElement searchBtn
        searchInput
                .shouldBe(visible)
                .sendKeys(groupName);
        searchInput
                .pressEnter();
        ElementsCollection results = searchPortal.shouldBe(visible).findAll(byXpath(".//*[contains(@class,'group-big-card')]"));
        return results;
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

    public SelenideElement getMyGroupImage(String groupName){
        String groupXPath = "img[@alt='" + groupName+"']";
        SelenideElement groupImage = $(byXpath(groupXPath));
        return groupImage;
    }
}
