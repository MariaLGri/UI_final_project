package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static io.qameta.allure.Allure.step;


@DisplayName("Автотесты для компании OFFER NOW, сайт компании, главная")
@Epic("WEB UI Тестирование")
@Feature("Основные элементы")
@Story("Отображение элементов главной страницы")
@Owner("Гришина М.Л")
public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Tag("mainpagetest")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка главной страницы, открытие, логотип, меню")
    void shouldDisplayMainPageElementsTest() {
        step("Проверяем наличие логотипа компании ", () -> {
            mainPage.checkLogoPage();
        });

        step("Проверяем наличие и состав меню сайта ", () -> {
            mainPage.checkMenuPage();
        });
    }

    @Test
    @Tag("mainpagetest")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка смены языка на главной странице")
    void shouldChangeLanguageOnMainPageTest() {
        mainPage.checkLanguageSwitchPage()
                .checkMenuEngPage();

    }

}