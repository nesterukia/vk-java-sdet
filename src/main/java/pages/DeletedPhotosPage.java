package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DeletedPhotosPage extends BasePage{
    private By lastDeletedPhotosCard = byXpath(".//*[contains(@class, 'grid-item')]");

    public void clearLastDeletedPhoto(){
        $(lastDeletedPhotosCard)
                    .shouldBe(visible.because("LastDeletedPhotosCard should be visible in DeletedPhotosPage"))
                    .click();


        By deleteBtn = byXpath(".//*[text()='Удалить']");
        $(deleteBtn)
                .shouldBe(visible.because("DeleteBtn should be visible in opened Deleted Picture Viewer"))
                .click();

        By modalWindow = byXpath(".//*[contains(@class, 'container') and contains(@class, 'size-small')]");
        $(modalWindow)
                .shouldBe(visible.because("ModalWindow should be visible."))
                .find(byXpath(".//*[text()='Удалить']"))
                    .shouldBe(visible.because("DeleteButton should be visible."))
                    .click();
    }
}
