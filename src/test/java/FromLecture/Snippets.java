package FromLecture;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {
    void browser_command_examples() {

        open("https://google.com");
        open("/customer/orders");     // -Dselenide.baseUrl=http://123.23.23.1
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("user", "password"));

        Selenide.back();     //перейти назад
        Selenide.refresh();  //обновить

        Selenide.clearBrowserCookies(); //после выполнения теста можно сделать очистку cookies чтобы не переотрывать браузер
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear();"); // no Selenide command for this yet

        Selenide.confirm(); // OK in alert dialogs
        Selenide.dismiss(); // Cancel in alert dialogs

        Selenide.closeWindow(); // close active tab
        Selenide.closeWebDriver(); // close browser completely

        Selenide.switchTo().frame("new");
        Selenide.switchTo().defaultContent();

        Selenide.switchTo().window("The Internet");
    }

    void selectors_examples() {
        $("div").click();
        element("div").click(); //синоним элемента $

        $("div", 2).click(); // цифра индекса обозначает номер индекса который берем

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click(); //ищет по полному совпадению
        $(withText("ull tex")).click(); //ищет по половине строки

        $(byTagAndText("div","full text"));
        $(withTagAndText("div","ull text"));

        $("").parent(); //ищет родителя, первый элемент, переходит на один уровень выше
        $("").sibling(1); //ищет братье/сестер сверху вниз
        $("").preceding(1); //ищет братье/сестер снизу вверх
        $("").closest("div");
        $("").ancestor("div"); // the same as closest - ищет первого предка вверх по дереву используя любой селектор
        $("div:last-child");

        $("div").$("h1").find(byText("abc")).click(); //ищем сначала первый div, внутри него
        //мы ищем первый h1, и внутри него ищем find by text или любые другие комбинации

        // very optional
        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();
    }

    void actions_examples() {
        $("").click();
        $("").doubleClick();
        $("").contextClick(); //то же самое что и right click

        $("").hover();

        $("").setValue("text"); //полностью очищает поле и записывает данные
        $("").append("text"); // не очищает поле и добавляет к нему текст
        $("").clear();
        $("").setValue(""); // clear

        $("div").sendKeys("c"); // hotkey c on element
        actions().sendKeys("c").perform(); //hotkey c on whole application - вызывает последовательность нажатия клавиш
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // Ctrl + F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f")); //chord - это значит одновременно нажать на control и f

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();


        // complex actions with keybord and mouse, example
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();
        //moveByOffset - передвинуть мышку на 300 точек вверх и вниз

        // old html actions don't work with many modern frameworks
        $("").selectOption("dropdown_option"); // работает только с классичискими drop downs
        $("").selectRadio("radio_options");
        //для работы с современными dropdowns - сначала нужно кликнуть на элемент, а потом уже выбирать элементы внутри списка

    }

    void assertions_examples() {            //все эти элеменеты одинаковые
        $("").shouldBe(visible);
        $("").shouldNotBe(visible);
        $("").shouldHave(text("abc"));
        $("").shouldNotHave(text("abc"));
        $("").should(appear);
        $("").shouldNot(appear);


        //longer timeouts
        $("").shouldBe(visible, Duration.ofSeconds(30)); //увеличивает стандартный таймаут


    }

    void conditions_examples() {
        $("").shouldBe(visible);      //эти 3 проверки составляют 90% всех проверок в селениде
        $("").shouldBe(hidden);
        $("").shouldHave(text("abc")); //игнорирует case и ищет не по полному совпадению

        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[0-9]abc$"));  //можно выдумать любую проверку

        $("").shouldHave(cssClass("red")); //проверяет только класс
        $("").shouldHave(cssValue("font-size", "12")); //можно проверить размер самого элемента

        $("").shouldHave(value("25")); //проверяем значение полей для ввода
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);

        $("").shouldHave(attribute("disabled"));
        $("").shouldHave(attribute("name", "example"));
        $("").shouldHave(attributeMatching("name", "[0-9]abc$"));

        $("").shouldBe(checked); // for checkboxes

        // Warning! Only checks if it is in DOM, not if it is visible! You don't need it in most tests!
        $("").should(exist); //проверяет что элемент находися в DOM

        // Warning! Checks only the "disabled" attribute! Will not work with many modern frameworks
        $("").shouldBe(disabled); //проверяет только атрибут disable, а не фактически disable
        $("").shouldBe(enabled);
    }

    void collections_examples() {

        $$("div"); // does nothing!

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1)); //удваляютяс все элементы для которых этот condition верный

        $$("div").first().click();
        elements("div").first().click(); // $("div").click() - то же самое
        $$("div").last().click();
        $$("div").get(1).click(); // the second! (start with 0)
        $("div", 1).click(); // same as previous
        $$("div").findBy(text("123")).click(); //  finds first - тоже самое что filter + first

        // assertions
        $$("").shouldHave(size(0)); //проверка на размер коллекции
        $$("").shouldBe(CollectionCondition.empty); // the same

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma")); //тексты должны быть ровно 3 и ровно в этом порядке на не полное соответствие
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma"));

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa")); //вне зависимоти от порядка, но кол-во элементов должно совпадать
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa"));

        $$("").shouldHave(itemWithText("Gamma")); // only one text - ищет только этот текст в коллекции

        $$("").shouldHave(sizeGreaterThan(0));
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3));
        $$("").shouldHave(sizeLessThanOrEqual(2));


    }

    void file_operation_examples() throws FileNotFoundException {

        File file1 = $("a.fileLink").download(); // only for <a href=".."> links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // more common options, but may have problems with Grid/Selenoid

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt"); // нужно нажать потом на submit
        // don't forget to submit!
        $("uploadButton").click();
    }

    void javascript_examples() {
        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);


    }
}
