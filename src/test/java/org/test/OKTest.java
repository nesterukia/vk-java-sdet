package org.test;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class OKTest {

    @Test
    public void OKSearchTest(){
        open("https://www.ok.ru");
        $(By.name("st.query")).setValue("Автоматизация");
        $(By.name("st.query")).pressEnter();
        $(By.name("18/ico_hobbies_18")).shouldHave(Condition.appear);
    }
}
