package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HhVacancyJavaQaPage;

import static io.qameta.allure.Allure.step;


@DisplayName("Автотесты OFFER NOW - Вакансии на HH")
@Epic("WEB UI Тестирование")
@Feature("Вакансии на HH")
@Story("Функционал страницы вакансии QA Java")
public class VacancyCompanyInHHTests extends TestBase {
    HhVacancyJavaQaPage vacancyJavaQaPage = new HhVacancyJavaQaPage();

    @Test
    @Owner("Гришина М.Л")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Открытие страницы вакансии Auto QA (Java)")
    public void vacancyPageTest() {
        step("Проверяем наименования страницы (вакансии)", () -> {
            vacancyJavaQaPage.checkResultNamePage();
        });
    }

    @Test
    @Owner("Гришина М.Л")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка видимости общей оценки компании ")
    void vacancyReviewStarCompanyTest() {

        step("Проверяем , что видно рейтинг ", () -> {
            vacancyJavaQaPage.checkStarsCompany();
        });
    }

    @Test
    @Owner("Гришина М.Л")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка перехода на страницу краткого описания компании")
    void vacancyCompanyTest() {

        step("Проверяем переход по клику на страницу описания компании ", () -> {
            vacancyJavaQaPage.checkCompanyClickPage();
        });

        step("Проверяем присутствие описания компании на странице", () -> {
            vacancyJavaQaPage.checkCompanyClickPageNew();
        });
    }
}

