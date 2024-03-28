package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PictureViewerPage {

    private SelenideElement otherFeaturesBtn = $(byXpath("//*[@id=\"photoLayerHeightCnt__ce635\"]/image-layer/div/div/div[1]/div[3]/div/div/div/div[2]/button"));
    private SelenideElement closeBtn = $(byXpath("//*[@id=\"photoLayerHeightCnt__ce635\"]/image-layer/div/div/button"));

    public PictureViewerPage deletePic(){
        otherFeaturesBtn
                .click();
        SelenideElement deleteBtn = $(byXpath("//*[@id=\"shortcut-menu-portal-3\"]/ul/li[7]/button"));
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
