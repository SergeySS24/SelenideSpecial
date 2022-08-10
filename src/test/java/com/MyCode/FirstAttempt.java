package com.MyCode;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FirstAttempt {
    @Test
    public void findSelenide() {
        Selenide.open("https://github.com/");
        $(".header-search-input").setValue("Selenide").pressEnter();
        $("f4").$("v-align-middle").find(byText("selenide/selenide")).click();


    }
}
