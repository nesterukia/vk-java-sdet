package pages;

import elements.LeftMenu;
import elements.TopMenu;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FeedPage extends BasePage implements LeftMenu, TopMenu {
    By momentsTab = byXpath(".//*[@data-l='t,to_moments']");
    By hobbiesTab = byXpath(".//*[@data-l='t,to_hobbies']");

    By feedList = byXpath(".//*[contains(@class, 'feed-list')]");
    @Override
    public void checkPage() {
        $(momentsTab).shouldBe(visible.because("MomentsTab should be visible in FeedPage."), Duration.ofSeconds(1));
        $(hobbiesTab).shouldBe(visible.because("HobbiesTab should be visible in FeedPage."), Duration.ofSeconds(1));
        $(feedList).shouldBe(visible.because("FeedList should be visible in FeedPage."), Duration.ofSeconds(1));
    }
}
