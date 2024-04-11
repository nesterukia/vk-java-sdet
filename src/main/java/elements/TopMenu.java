package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TopMenu {
    private By root = byXpath(".//*[@data-l='t,navigationToolbar' and @class='toolbar_c']");
    private By profileSettings = byXpath(".//button[@aria-label='Настройки профиля']");
    private By userDropdownMenu = byXpath(".//*[@id='user-dropdown-menu']");

    public SelenideElement getRoot(){
        return $(root);
    }

    public LoginPage logOut(){
        $(profileSettings)
                .shouldBe(visible.because("ProfileSettings should be visible in TopMenu."))
                .click();
        $(userDropdownMenu)
                .shouldBe(visible.because("UserDropdownMenu should be visible in TopMenu."))
                .hover();
        By logOutBtn = byXpath(".//a[text()='Выйти']");
        $(logOutBtn)
                .shouldBe(visible.because("LogOutBtn should be visible in TopMenu."))
                .click();
        By confirmBtn = byXpath(".//input[@value='Выйти']");
        $(confirmBtn)
                .shouldBe(visible.because("ConfirmBtn should be visible in TopMenu."))
                .click();
        return new LoginPage();
    }
}
