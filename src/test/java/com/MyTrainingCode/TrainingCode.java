package com.MyTrainingCode;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class TrainingCode {

    @Test
    public void positiveAuthorizationTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--use-fake-ui-for-media-stream",
                "--headless",
                "--disable-web-security",
                "--ignore-certificate-errors",
                "--allow-running-insecure-content",
                "--allow-insecure-localhost",
                "--no-sandbox",
                "--disable-gpu",
                "--enable-allow-microphone",
                "–disable-notifications"
        );

        //Учился двигать мышкой по экрану
        open("https://brains.tassta.com/");
        $("#login_port").setValue("65116");
        $("#login_username").setValue("sergey02");
        $("#login_password").setValue("brains16");
        $(".ant-col").$(".gDqjUc").shouldHave(Condition.text("Log In")).click();
        sleep(1200);
        // actions().moveByOffset(250, 110).click().perform(); //Channels
        // actions().moveByOffset(325, 120).click().perform(); //blocked
        // actions().moveByOffset(580, 200).click().perform(); //main - 3 dot button
        // actions().moveByOffset(508, 80).click().perform(); // успешный клик на Ascending by ID
        //actions().moveByOffset(240, 134).click().perform(); //успешный клик на Recent


        actions().moveByOffset(240, 95).click().perform(); //успешный клик на Recent

        //$(".ant-col").$(".gDqjUc").shouldHave(Condition.text("Log In")).click();

        //ChromeOptions.CAPABILITY = "platform",
    }

//*************************************************************

    //ChromeOptions.CAPABILITY = confirm("Allow")

    //ChromeOptions options = new ChromeOptions();
    //options.setCapability(ACCEPT_IMMEDIATELY.name(), "Allow");


    //SelenideDriver browser1 = new SelenideDriver();
    //SelenideDriver browser = new SelenideDriver();
    // SelenideDriver browser1=new SelenideDriver((Config) new FirefoxDriver());
    // SelenideDriver browser2=new SelenideDriver((Config) new FirefoxDriver());


    // @BeforeEach
    void setUp() {
        driver().close();
        //  browser1 = new SelenideDriver(new SelenideConfig().browser(browser).baseUrl("https://brains.tassta.com/"));
        //  browser1 = new SelenideDriver(new SelenideConfig().browser(browser).baseUrl("https://yandex.ru"));
    }

    // @AfterEach
    void tearDown() {
        //  browser1.close();
        //  browser2.close();
    }

    // @Test
    void canUseTwoBrowsersInSameThread() {

        //  browser1.open("https://google.com");
        //  browser2.open("http://yandex.ru");


        // browser1.open("https://brains.tassta.com/" + browser1.config().browser());
        // browser2.open("https://yandex.ru" + browser2.config().browser());

    }

    //@Test
    //public void createAndSwitchToAnotherTab(){
    //  $(byCssSelector("body")).sendKeys(Keys.CONTROL+"t");
    //  tabs = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles()); switchTo().window(tabs.get(1)); }

    @BeforeAll
    static void preparation() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("use-fake-ui-for-media-stream");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void start() {
        open("https://brains.tassta.com/");
        $(byId("login_port")).setValue("65102");
        $("#login_username").setValue("Alfred");
        $("#login_password").setValue("todayis1");
        $(".ant-col").$(".gDqjUc").shouldHave(Condition.text("Log In")).click();
        sleep(5000);
        $(".ant-btn-text", 2).click();

        open("https://brains.tassta.com/");
        sleep(50);
        $("#login_port").clear();
        $(".ant-input-lg").sendKeys(Keys.BACK_SPACE);
        $(".ant-input-lg").sendKeys(Keys.BACK_SPACE);
        $(".ant-input-lg").sendKeys(Keys.BACK_SPACE);
        $(".ant-input-lg").sendKeys(Keys.BACK_SPACE);
        $(".ant-input-lg").sendKeys(Keys.BACK_SPACE);
        sleep(300);
    }
  //*************************************************************


    @Test
    void apiTest() {
//        given()
//                .when()
//                .get("https://wolt.com/en/discovery/category/cafe")
//                .then()
//                .statusCode(200);
    }


    public class Practicetests {

        //@Test
        // void pictureCheck() {

        //List links=driver.findElements(By.tagName("img"));
        // this will display list of all images exist on page
        // for(WebElement ele:links){
        //  System.out.println(ele.getAttribute("src"));
    }
    // .shouldHave(Condition.attribute("img", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));

    //.find(Condition.attribute("img src", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));



    // $(".CountryFrontHeroBanner-module__root___txolf").$("img")
    //       .shouldHave(Condition.image);

    // .shouldHave(Condition.image);

    //.$(".img src")
    // .shouldHave(Condition.attributeMatching("img src", "https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg"));


    // $("image")
    //  .shouldBe(Condition.image"https://cdn.wolt.com/frontpage-assets/hero-images/0_Sunday.jpg");



//    HashMap cities=new HashMap<String, String>();
//               cities.put("key1", "Ammochostos");
//                cities.put("key2", "Larnaca");
//                cities.put("key3", "Limassol");
//                cities.put("key4", "Nicosia");
//                cities.put("key5", "Paphos");
//
//
//    String s = null;
//                for (Object city: cities.values()) {
//        s = (String) city;
//
//    }
//                System.out.println(s);

/*
    @ValueSource(strings = {"Ammochostos", "Larnaca", "Limassol", "Nicosia", "Paphos"})
    @ParameterizedTest(name = "Check all cities")
    void checkTowns(String cities) {
        $$(".CitySelection-module__contentWrapper___BWfyh").find(Condition.text(cities)).shouldBe(Condition.visible);
    }


   }
   }
 */

//Assertions.assertEquals("Cyprus", $(".SideNav-module__sideNavigationTitle___BELWP"));
//Assertions.assertEquals("Cyprus", $(".SideNav-module__sideNavigationTitle___BELWP"));


// $$(".CitySelection-module__contentWrapper___BWfyh").first().shouldHave(Condition.text("Ammochostos"));

//$$(".CitySelection-module__contentWrapper___BWfyh").shouldHave(); //можно подставить цикл for


//    @CsvSource(value = {"For couriers | https://explore.wolt.com/en/cyp/couriers",
//            "For restaurants | https://wolt.com/en/merchants"},
//            delimiter = '|')
//
//    @ParameterizedTest(name = "ch)")
//    void specialTest(String testData, String expectedResult) {
//
//        $("#footer").scrollTo();
//
//        $(".FooterLinkGroup__Content-sc-1vexfqi-2").shouldHave(Condition.text(testData));
//        $(".Footer__Link-sc-1ki6z7e-18").click();
//        webdriver().shouldHave(url(expectedResult));
//        Selenide.back();



}
