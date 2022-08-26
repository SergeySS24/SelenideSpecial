package com.MyCode;

import com.codeborne.selenide.*;
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

    }

    //JUNIT5 - SEARCHING LICENSE.MD
    @Test
    void licenseCheck() {
        Selenide.open("https://github.com/junit-team/junit5");

        //$$(".Layout-main").first().shouldHave(Condition.text("github")); //на поиск первого элемента в списке

        $$(".Layout-main").findBy(Condition.text("LICENSE.md"))
                .shouldBe(Condition.visible);

        //$$(".Layout-main").findBy(Condition.text("LICENSE.md"))  //вариант №2
                //.shouldHave(Condition.text("LICENSE.md"));
    }

    //JUNIT5 - SEARCHING LICENSE.MD - RELEASE 5.9
    @Test
    void releaseCheck() {
        Selenide.open("https://github.com/junit-team/junit5");
        $$(".Layout-main").findBy(Condition.text("Release 5.9")).shouldBe(Condition.visible);

        //$$(".Layout-main").filterBy(Condition.text("LICENSE.md"))
        // .shouldHave(CollectionCondition.texts("Release 5.9")); //вариант №2
        
        //$$(".Layout-main").shouldHave(CollectionCondition.texts("Release 5.9")); //Вариант №3
    }

    //JUNIT5 - Languages - Java 97.5%
    @Test
    void languageCheck() {
        Selenide.open("https://github.com/junit-team/junit5");
        $(".Layout-sidebar").$(".BorderGrid-row",5).shouldHave(Condition.text("97.5%"));

        //вариант №2
        //$$(".Layout-sidebar").filterBy(Condition.text("Languages")).shouldHave(CollectionCondition.texts("97.5%"));
    }

    //JUNIT5 - Gradle Enterprise - link
    @Test
    void linkCheck() {
        Selenide.open("https://github.com/junit-team/junit5");
        //$$(".entry-content").filterBy(Condition.text("Gradle Enterprise"))
       //         .shouldHave(CollectionCondition.texts("Gradle Enterprise"));

        //$(".Layout-main").$(".entry-content").$(byText("JUnit 5 utilizes"))
                //.shouldHave(Condition.text("JUnit 5 utilizes"));

        $(".Layout-main").$(".entry-content").$(byLinkText("Gradle Enterprise"))
                .shouldHave(Condition.href("https://gradle.com/"));
    }

    //JUNIT5 - gradlew clean publishToMavenLocale - code
    @Test
    void codeSearch() {
        Selenide.open("https://github.com/junit-team/junit5");
        $(".Layout-main").$(".entry-content").$(byAttribute("code", "gradlew clean publishToMavenLocal")).hover();


                //.shouldHave(Condition.text("following command"));
    }

}











