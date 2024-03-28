package elements;

import com.codeborne.selenide.SelenideElement;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TopMenu {
    private SelenideElement root = $(byXpath("//*[@id=\"topPanel\"]/div/div[1]/div"));
    private SelenideElement profileSettings = $(byXpath("//*[@id=\"hook_Block_ToolbarUserDropdown\"]/div/button"));

    public SelenideElement getRoot(){
        return root;
    }

    public LoginPage logOut(){
        profileSettings.click();
        profileSettings.hover();
        SelenideElement logOutBtn = $(byXpath("//*[@id=\"user-dropdown-menu\"]/div[1]/div/div[1]/div[2]/a"));
        logOutBtn
                .shouldBe(visible)
                .click();
        return new LoginPage();
    }
}
