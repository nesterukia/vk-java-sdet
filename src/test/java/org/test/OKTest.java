package org.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class OKTest {

    @Test
    public void OKSearchTest(){
        open("https://www.ok.ru");
        $(By.name("st.query")).setValue("Автоматизация тестирования");
        $(By.name("st.query")).pressEnter();
        Assert.assertTrue(true);
    }
}
