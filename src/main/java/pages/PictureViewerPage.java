package pages;

import elements.PictureViewerCommentsSection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PictureViewerPage extends BasePage implements PictureViewerCommentsSection {

    private By widgetBtns = byXpath(".//*[@id = 'hook_Block_ActionsPLLB']");
    private By otherFeaturesBtn =
            byXpath(".//button[contains(@class, 'action-button-container') and contains(@class, 'button-clean')]");
    private By closeBtn =
            byXpath("//button[contains(@class, 'panel_close')]");
    private By deleteBtn = byXpath(".//span[text()='Удалить фотографию']/..");

    private By commentForm = byXpath(".//*[contains(@class, 'comment-form')]");

    public PictureViewerPage(){
        checkPage();
    }

    @Override
    public void checkPage() {
        $(commentForm).shouldBe(visible.because("CommentForm should be visible in PictureViewerPage."));
        $(widgetBtns).shouldBe(visible.because("WidgetBtns should be visible in PictureViewerPage."));
        $(closeBtn).shouldBe(visible.because("CloseBtn should be visible in PictureViewerPage."));
    }
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
