package pages;

import elements.LeftMenu;
import elements.TopMenu;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage implements LeftMenu, TopMenu {
    private By followBtn = byXpath(".//ul[contains(@class,'header-action-menu')]/*[contains(@data-l, 'join')]");
    private By statusBtn = byXpath(".//ul[contains(@class,'header-action-menu')]/*[contains(@data-l, 'join')]");
    private By messageBtn = byXpath(".//ul[contains(@class,'header-action-menu')]/li/*[contains(@href, 'messages')]");
    private By groupName = byXpath(".//*[@class='group-name']");
    private By middleColumnMenu = byXpath(".//*[@aria-label='Меню в средней колонке']");

    public GroupPage(){
        checkPage();
    }
    @Override
    public void checkPage(){
        $(followBtn).shouldBe(visible.because("FollowButton should be visible in GroupPage."));
        $(groupName).shouldBe(visible.because("GroupName should be visible in GroupPage."));
        $(middleColumnMenu).shouldBe(visible.because("MiddleColumnMenu should be visible in GroupPage."));
    }

    public void follow() {
        $(followBtn)
                .shouldBe(visible.because("FollowButton should be visible in GroupPage."), Duration.ofMillis(1000))
                .click();
    }
    public void unfollow(){
        $(statusBtn)
                .shouldBe(visible.because("StatusButton should be visible in GroupPage."))
                .click();
        $(statusBtn)
                .hover();
        By quitButton = byXpath(".//*[text()='Выйти из группы']");
        $(quitButton)
                .shouldBe(visible.because("QuitButton should be visible in GroupPage."))
                .click();
        By submitButton = byXpath(".//*[@id='hook_FormButton_submit']");
        $(submitButton)
                .shouldBe(visible.because("SubmitButton should be visible in GroupPage."))
                .click();
    }

    public boolean isFollowed(){
        return $(messageBtn).is(visible, Duration.ofMillis(1000));
    }
}
