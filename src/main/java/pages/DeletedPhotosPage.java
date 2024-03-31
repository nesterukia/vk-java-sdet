package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DeletedPhotosPage extends BasePage{
    private SelenideElement lastDeletedPhotosCard = $(byXpath(".//*[contains(@class, 'grid-item')]"));

    public void clearLastDeletedPhoto(){
        lastDeletedPhotosCard
                    .shouldBe(visible)
                    .click();

        SelenideElement deleteBtn = $(byXpath(".//*[text()='Удалить']"));
        deleteBtn
                .shouldBe(visible)
                .click();

        SelenideElement modalWindow = $(byXpath(".//*[contains(@class, 'container') and contains(@class, 'size-small')]"));
        SelenideElement confirmBtn = modalWindow.shouldBe(visible).find(byXpath(".//*[text()='Удалить']"));
        confirmBtn
                .shouldBe(visible)
                .click();
    }
}
