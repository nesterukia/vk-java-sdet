package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotosMenuPage extends BasePage{
    private By deletedPhotosTab = byXpath(".//*[@title='Удалённые фотографии']");

    public DeletedPhotosPage openDeletedPhotosPage(){
        $(deletedPhotosTab)
                .shouldBe(visible.because("DeletedPhotosTab should be visible in PhotosMenuPage."))
                .click();
        return new DeletedPhotosPage();
    }
}
