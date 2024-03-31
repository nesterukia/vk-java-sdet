package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage{
    private SelenideElement followBtn = $(byXpath(".//*[@id=\"hook_Block_AltGroupMainMenu\"]/ul/div/a"));
    private SelenideElement statusBtn = $(byXpath("//*[@id=\"hook_Block_AltGroupMainMenu\"]/ul/div/div/span"));

    public void follow(){
        followBtn
                .shouldBe(visible)
                .click();
    }

    public void unfollow(){
        statusBtn
                .shouldBe(visible)
                .click();
        statusBtn
                .hover();

        $(byText("Выйти из группы"))
                .shouldBe(visible)
                .click();

        SelenideElement quitButton = $(byXpath(".//*[@id='hook_FormButton_submit']"));
        quitButton
                .shouldBe(visible)
                .click();
    }
}
