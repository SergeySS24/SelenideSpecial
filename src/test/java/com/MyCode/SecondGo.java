package com.MyCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

//SEARCH FOR JUNIT5 CONTRIBUTOR sbrannen

public class SecondGo {

    @BeforeAll
    static void preparation() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void contributorSearch2() { // КАК ПРАИЛЬНО ДЕЛАТЬ

        Selenide.open("https://github.com/junit-team/junit5");

        $(".BorderGrid--spacious").$(byText("Contributors")).ancestor("div")
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
        $(".BorderGrid--spacious").$(byText("Contributors")).ancestor(".BorderGrid-cell")
                .$(".mr-2", 2).hover();
        $(".Popover-message").$(".f5").shouldHave(Condition.text("marcphilipp"));

        //$(".BorderGrid--spacious").$(".BorderGrid-row", 4).$(".list-style-none")
                //.$(".mr-2").$(".data-hovercard-url").$(byValue("/users/marcphilipp/hovercard")).hover();
    }

    //JUNIT5 - PRESENCE OF LICENSE.MD
    @Test
    void licenseCheck() {
        Selenide.open("https://github.com/junit-team/junit5");
        //$(".Layout-main").$(".Details-content--hidden-not-important").$(".Box-row", 34).$(".js-navigation-open")
                //.shouldHave(Condition.text("LICENSE.md"));

          //$$(".js-details-container").get(35).$(".js-navigation-open").shouldHave(Condition.text("LICENSE.md"));

            $$(".BorderGrid--spacious").findBy(Condition.value("marcphilipp")).shouldHave(Condition.value("marcphilipp"));

        //$$(".Layout-main").first().shouldHave(Condition.text("github")); //УСПЕШНЫЙ ТЕСТ!!!
       // $$(".Layout-main").findBy(Condition.text("LICENSE.md"))
               // .shouldHave(Condition.text("LICENSE.md"));

       // $$(".Layout-main").findBy(Condition.text("LICENSE.md"))
                //.shouldBe(Condition.visible);


    }

}











