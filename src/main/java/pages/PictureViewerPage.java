package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PictureViewerPage {

    private  By widgetBtns = byXpath(".//*[@id = 'hook_Block_ActionsPLLB']");
    private By otherFeaturesBtn =
            byXpath(".//button[contains(@class, 'action-button-container') and contains(@class, 'button-clean')]");
    private By closeBtn =
            byXpath("//button[contains(@class, 'panel_close')]");
    private By deleteBtn = byXpath(".//span[text()='Удалить фотографию']/..");;

    public PictureViewerPage deletePic(){
        $(widgetBtns).shouldBe(visible.because("Every widget should be visible in PictureViewerPage."));
        $(otherFeaturesBtn)
                .shouldBe(visible.because("OtherFeaturesBtn should be visible in PictureViewerPage."))
                .click();
        $(deleteBtn)
                .shouldBe(visible.because("DeleteBtn should be visible in PictureViewerPage."))
                .click();
        return this;
    }

    public void close(){
        $(closeBtn).shouldBe(visible.because("CloseBtn should be visible PictureViewerPage"))
                .click();
    }
}
