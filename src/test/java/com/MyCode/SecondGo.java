package com.MyCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;


//SEARCH FOR JUNIT CONTRIBUTOR
public class SecondGo {

    @BeforeAll
   static void preparation() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void contributorSearch() {
        Selenide.open("https://github.com/junit-team/junit5");
        $(".BorderGrid--spacious").$(".BorderGrid-row", 4).shouldHave(Condition.text("Contributors")).hover();
    }
}
