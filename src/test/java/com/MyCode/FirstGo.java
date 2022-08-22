package com.MyCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

//CHECKING JUNIT

public class FirstGo {
    @BeforeAll
    public static void preparation() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void headerVerification() {
        Selenide.open("https://github.com/");
        $(".header-search-input").setValue("junit").pressEnter();
        //$$(".repo-list").first().$(".v-align-middle").click();
        //$(".repo-list").$("li.repo-list-item").$(".v-align-middle").click(); //Вариант 2
        //$("#repository-container-header").$(".wb-break-word").shouldHave(Condition.text("junit-team / junit4"));

       // $(".repo-list").$(".repo-list-item", 2).$(".v-align-middle").click();
        $(".repo-list").$(".repo-list-item", 3).$(".v-align-middle").click();



    }
}
