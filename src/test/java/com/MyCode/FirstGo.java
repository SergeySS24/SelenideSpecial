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
        //sleep(200);
       // actions().moveByOffset(475, 111).click().perform();
        actions().moveByOffset(82, 22).click().perform();
    }

    @Test
    void checkMouseClick2() {
        Selenide.open("https://piter.allithave.ru/");
        sleep(100);
        // actions().moveByOffset(475, 111).click().perform();
       // actions().moveByOffset(400, 200).click().perform(); //каталог
        //actions().moveByOffset(320, 200).click().perform(); //каталог левый край
       // actions().moveByOffset(700, 190/205).click().perform(); //хиты продаж
       // actions().moveByOffset(750, 110/115).click().perform(); //строка каталога
        //actions().moveByOffset(730, 15).click().perform(); //мой заказ

    }

}
