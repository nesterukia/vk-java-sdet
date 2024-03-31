package elements;

import com.codeborne.selenide.SelenideElement;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TopMenu {
    private SelenideElement root = $(byXpath(".//*[@data-l='t,navigationToolbar' and @class='toolbar_c']"));
    private SelenideElement profileSettings = $(byXpath(".//button[@aria-label='Настройки профиля']"));
    private SelenideElement userDropdownMenu = $(byXpath(".//*[@id='user-dropdown-menu']"));

    public SelenideElement getRoot(){
        return root;
    }

    public LoginPage logOut(){
        profileSettings
                .shouldBe(visible)
                .click();
        userDropdownMenu
                .shouldBe(visible)
                .hover();
        SelenideElement logOutBtn = $(byXpath(".//a[text()='Выйти']"));
        logOutBtn
                .shouldBe(visible)
                .click();
        SelenideElement confirmBtn = $(byXpath(".//input[@value='Выйти']"));
        confirmBtn
                .shouldBe(visible)
                .click();
        return new LoginPage();
    }
}
