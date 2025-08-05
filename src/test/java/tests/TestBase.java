package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HhVacancyJavaQaPage;
import pages.MainPage;
import pages.WorkFormWithUsPage;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class TestBase {
    protected HhVacancyJavaQaPage vacancyJavaQaPage = new HhVacancyJavaQaPage();
    protected WorkFormWithUsPage workFormWithUsPage = new WorkFormWithUsPage();
    protected MainPage mainPage = new MainPage();

    @BeforeAll
    static void installСonfiguration() {
        Configuration.baseUrl = TestConfig.getBaseUrl();
        Configuration.browser = TestConfig.getBrowser();
        Configuration.browserVersion = TestConfig.getBrowserVersion();
        Configuration.browserSize = TestConfig.getBrowserSize();

        if (!TestConfig.isLocalRun()) {
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub",
                    TestConfig.getSelenoidUserLogin(),
                    TestConfig.getSelenoidUserPassword(),
                    TestConfig.getSelenoidUrl());
        }


        Configuration.pageLoadStrategy = TestConfig.getPageLoadStrategy();
        Configuration.timeout = TestConfig.getTimeout();


        Configuration.reportsFolder = TestConfig.getReportsFolder();


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

        if (this instanceof WorkPageTests) {
            step("Открываем страницу 'Работа у нас' ", () -> {
                workFormWithUsPage.openPage();
            });
        }
        if (this instanceof MainPageTests) {
            step("Проверяем открытие главной страницы OFFER NOW", () -> {
                mainPage.openPage();
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