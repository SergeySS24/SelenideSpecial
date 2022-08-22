package com.MyCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

//SEARCH FOR JUNIT5 CONTRIBUTOR sbrannen

public class SecondGo {

    @BeforeAll
    static void preparation() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void contributorSearch2() { // КАК ПРАИЛЬНО ДЕЛАТЬ

        Selenide.open("https://github.com/junit-team/junit5");

        $(".BorderGrid--spacious").$(Selectors.byText("Contributors")).ancestor("div")
                .$(".list-style-none").$(".mr-2").hover();
        $(".Popover-message").$(".f5").shouldHave(Condition.text("sbrannen"));

    }

    @Test
    void contributorSearch1() { //КАК НЕ СОВСЕМ ПРАВИЛЬНО ДЕЛАТЬ

        Selenide.open("https://github.com/junit-team/junit5");

        $(".BorderGrid--spacious").$(".BorderGrid-row", 4).$(".list-style-none")
                .$(".mr-2").hover();
        $(".Popover-message").$(".f5").shouldHave(Condition.text("sbrannen"));
    }

    //SEARCH FOR JUNIT5 CONTRIBUTOR marcphilipp
    @Test
    void contributorSearch3() {
        Selenide.open("https://github.com/junit-team/junit5");
        $(".BorderGrid--spacious").$(Selectors.byText("Contributors")).ancestor(".BorderGrid-cell")
                .$(".mr-2", 2).hover();
        $(".Popover-message").$(".f5").shouldHave(Condition.text("marcphilipp"));



    }

}











