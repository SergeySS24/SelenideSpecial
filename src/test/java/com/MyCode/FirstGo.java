package com.MyCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FirstGo {
    @BeforeAll
    public static void preparation() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void headerVerification() {
        Selenide.open("https://github.com/");
        $(".header-search-input").setValue("junit").pressEnter();
        //$(".repo-list").$(".repo-list-item").shouldHave(Condition.text("junit-team/junit4")).click();
        $$(".repo-list").first().$(".v-align-middle").click();
        //$$("ul repo-list").find(Condition.value("li repo-list-item")).
        //$(".repository-container-header").$("a")
                //find(Condition.value("#repo-content-pjax-container"))
               // .shouldHave(Condition.text("junit-team/junit4"));
                //shouldHave(Condition.text("junit-team/junit4"));

    }
}
