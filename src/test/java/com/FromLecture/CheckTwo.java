package com.FromLecture;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckTwo {

    @BeforeAll
    public static void preparation() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void findContributor() {
        Selenide.open("https://github.com/selenide/selenide");

        //$("Layout-sidebar").$(byText("Contributors")).ancestor("div").$$("ul li").first().hover();

        $(".Layout-sidebar").$(byText("Contributors")).ancestor("div").$$("ul li").first().hover();
        //$(".Popover-message").shouldHave(text("asolntsev"));
        $$(".Popover-message").first().shouldHave(text("asolntsev"));

        sleep(500);
    }
}
