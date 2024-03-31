package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PhotosMenuPage extends BasePage{
    private SelenideElement deletedPhotosTab = $(byXpath(".//*[@title='Удалённые фотографии']"));

    public DeletedPhotosPage openDeletedPhotosPage(){
        deletedPhotosTab
                .shouldBe(visible)
                .click();
        return new DeletedPhotosPage();
    }
}
