package com.MyCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

//CHECKING JUNIT

public class FirstGo {
    @BeforeAll
    public static void preparation() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void headerVerification() {
        Selenide.open("https://github.com/");
        $(".header-search-input").setValue("junit").pressEnter();
        $$(".repo-list").first().$(".v-align-middle").click();
        //$(".repo-list").$("li.repo-list-item").$(".v-align-middle").click(); //Вариант 2
        $("#repository-container-header").$(".wb-break-word").shouldHave(Condition.text("junit-team / junit4"));

        //$(".repo-list").$(".repo-list-item", 2).$(".v-align-middle").click(); //Выбор другого элемента из списка используя индексы

    }

    @Test
    void checkMouseClick() {
        Selenide.open("https://ru.shein.com/Home");
        actions().moveByOffset(323, 111).click().perform();

    }

}
