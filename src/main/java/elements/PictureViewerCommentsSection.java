package elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.PictureViewerPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public interface PictureViewerCommentsSection {
    By descriptionElement = byXpath(".//*[@data-l='t,textField-text']");
    By description = byXpath(".//*[@tsid='TextFieldText']");
    By descEditor = byXpath(".//textArea[@data-l='t,textField-editor']");
    By saveNewDescButton = byXpath(".//button[@data-l='t,textField-save']");
    By cancelNewDescButton = byXpath(".//button[@data-l='t,textField-cancel']");

    default void addDescription(String text){
        $(descriptionElement)
                .shouldBe(visible.because("Description should be visible in PictureViewerCommentsSection."), Duration.ofSeconds(1))
                        .click();
        $(descEditor)
                .should(exist.because("Description should exist in PictureViewerCommentsSection."), Duration.ofSeconds(1))
                .sendKeys(text);
    }

    default void saveNewDesc(){
        $(saveNewDescButton)
                .shouldBe(visible.because("SaveNewDescButton should be visible in PictureViewerCommentsSection."), Duration.ofSeconds(1))
                .click();
    }

    default String getDescription(){
        return $(description).getText();
    }
}
