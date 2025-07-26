package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HhVacancyJavaQaPage;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class TestBase {
    protected HhVacancyJavaQaPage vacancyJavaQaPage = new HhVacancyJavaQaPage();

    @BeforeAll
    static void installСonfiguration() {
        Configuration.reportsFolder = "build/reports";
        Configuration.baseUrl = "https://penza.hh.ru";
        Configuration.browserSize = System.getProperty("screenResolution", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "127.0");
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 15000;
        Configuration.remote = String.format(
                "https://%s:%s@%s/wd/hub",
                System.getProperty("selenoidUserLogin", "user1"),
                System.getProperty("selenoidUserPassword", "1234"),

                System.getProperty("selenoidUrl", "selenoid.autotests.cloud")
        );


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;


    }

    @BeforeEach

    void installСonfigurationBefore() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());


        if (this instanceof VacancyCompanyInHHTests) {
            step("Открываем страницу вакансии Auto QA (Java)", () -> {
                vacancyJavaQaPage.openPage();
            });
        }
    }


    @AfterEach
    void addAttachments() {

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();

    }
}