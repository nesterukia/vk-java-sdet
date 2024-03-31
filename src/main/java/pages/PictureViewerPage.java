package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PictureViewerPage {

    private  SelenideElement widgetBtns = $(byXpath(".//*[@id = 'hook_Block_ActionsPLLB']"));
    private SelenideElement otherFeaturesBtn =
            $(byXpath(".//button[contains(@class, 'action-button-container') and contains(@class, 'button-clean')]"));
    private SelenideElement closeBtn =
            $(byXpath("//button[contains(@class, 'panel_close')]"));
    private SelenideElement deleteBtn = $(byXpath(".//span[text()='Удалить фотографию']/.."));;

    public PictureViewerPage deletePic(){
        // Все кнопки должны прогрузиться
        widgetBtns.shouldBe(visible);

        otherFeaturesBtn
                .shouldBe(visible)
                .click();
        deleteBtn
                .shouldBe(visible)
                .click();
        return this;
    }

    public void close(){
        closeBtn.shouldBe(visible)
                .click();
    }
}
