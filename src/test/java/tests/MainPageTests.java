package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainOfferNowPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


@DisplayName("Автотесты для компании OFFER NOW, сайт компании, главная")
@Owner("Гришина М.Л")
public class MainPageTests extends TestBase {
    MainOfferNowPage mainOfferNowPage = new MainOfferNowPage();

    @Test
    @DisplayName("Проверка главной страницы, открытие, логотип, меню")
    void shouldDisplayMainPageElements() {
        step("Проверяем открытие главной страницы OFFER NOW", () -> {
            mainOfferNowPage.openPage();
        });

        step("Проверяем наличие логотипа компании ", () -> {
            mainOfferNowPage.checkLogoPage();
        });

        step("Проверяем наличие и состав меню сайта ", () -> {
            mainOfferNowPage.checkMenuPage();
        });
    }

    @Test
    @DisplayName("Проверка смены языка на главной странице")
    void shouldChangeLanguageOnMainPage() {
        step("Проверяем открытие главной страницы OFFER NOW", () -> {
            mainOfferNowPage.openPage();
        });

        step("Клик по ссылке смены языка ", () -> {
            mainOfferNowPage.checkLanguageSwitch();
        });

        step("Проверяем что страница отображена на ENG языке ", () -> {
            mainOfferNowPage.checkMenuEngPage();
        });

    }


}