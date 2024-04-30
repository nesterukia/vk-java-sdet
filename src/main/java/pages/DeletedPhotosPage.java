package pages;

import com.codeborne.selenide.SelenideElement;
import elements.LeftMenu;
import elements.TopMenu;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DeletedPhotosPage extends BasePage implements LeftMenu, TopMenu {
    private By lastDeletedPhotosCard = byXpath(".//*[contains(@class, 'grid-item')]");
    private By albumHeaderTitle = byXpath(".//h2[contains(@class, 'album-header-title') and text()='Удалённые фотографии']");

    @Override
    public void checkPage() {
        $(lastDeletedPhotosCard).shouldBe(visible.because("LastDeletedCard should be visible in DeletedPhotosPage."));
        $(albumHeaderTitle).shouldBe(visible.because("AlbumHeaderTitle should be visible in DeletedPhotosPage."));
    }
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
