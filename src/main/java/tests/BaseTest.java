package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import elements.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

abstract public class BaseTest {

    protected final User VALID_USER =
            new User("technopol66 technopol66","technopol66", "technopolisPassword");
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://ok.ru/";
    }

    @BeforeEach
    public void init(){
        setup();
        open("/");
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
