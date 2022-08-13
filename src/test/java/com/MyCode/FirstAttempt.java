package com.MyCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstAttempt {

    @BeforeAll
    public static void preparation() {
        //Configuration.holdBrowserOpen = true;
    }
    @Test
    public void findSelenide() {
        Selenide.open("https://github.com/");
        $(".header-search-input").setValue("Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));






    }
}
