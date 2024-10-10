package org.allure.junit5_bamboo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {


    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void setupSelenoid() {
        Configuration.remote = "https://localhost:4444/wd/hub";
    }

    @Test
    public void testMainPage() {
        Allure.step("Open main page", (step) -> {
            open("https://www.saucedemo.com");
        });

        Allure.step("The login logo should be visible", (step) -> {
            $(".login_logo").shouldBe(Condition.visible);
        });
    }

}
