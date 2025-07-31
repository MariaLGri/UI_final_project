package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import static io.qameta.allure.Allure.step;


@DisplayName("Автотесты для компании OFFER NOW, сайт компании, главная")
@Epic("WEB UI Тестирование")
@Feature("Основные элементы")
@Story("Отображение элементов главной страницы")

public class MainPageTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Owner("Гришина М.Л")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка главной страницы, открытие, логотип, меню")
    void shouldDisplayMainPageElements() {
        step("Проверяем наличие логотипа компании ", () -> {
            mainPage.checkLogoPage();
        });

        step("Проверяем наличие и состав меню сайта ", () -> {
            mainPage.checkMenuPage();
        });
    }

    @Test
    @Owner("Гришина М.Л")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка смены языка на главной странице")
    void shouldChangeLanguageOnMainPage() {
        step("Клик по ссылке смены языка ", () -> {
            mainPage.checkLanguageSwitch();
        });

        step("Проверяем что страница отображена на ENG языке ", () -> {
            mainPage.checkMenuEngPage();
        });

    }

}