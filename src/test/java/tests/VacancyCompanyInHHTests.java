package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HhVacancyJavaQaPage;
import static io.qameta.allure.Allure.step;


@DisplayName("Автотесты для компании OFFER NOW, вакансия на сайте HH, переход на сайт")
@Owner("Гришина М.Л")
public class VacancyCompanyInHHTests extends TestBase {
    HhVacancyJavaQaPage vacancyJavaQaPage = new HhVacancyJavaQaPage();

    @Test
    @DisplayName("Проверка открытия страницы вакансии Auto QA (Java)")
    public void vacancyPageTest() {
        step("Открытие страницы вакансии", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем наименования страницы (вакансии)", () -> {
            vacancyJavaQaPage.checkResultNamePage();
        });
    }

    @Test
    @DisplayName("Проверка перехода на страницу краткого описания компании")
    public void vacancyReviewStarUserTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем переход по клику на страницу описания компании ", () -> {
            vacancyJavaQaPage.checkCompanyClickPage();
        });

    }


    @Test
    @DisplayName("Проверка видимости общей оценки компании ")
    void vacancyReviewStarCompanyTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем , что видно рейтинг ", () -> {
            vacancyJavaQaPage.checkStarsCompany();
        });
    }

    @Test
    @DisplayName("Проверка перехода на страницу краткого описания компании для вакансии")
    void vacancyCompanyTest() {
        step("Проверяем открытие страницы вакансии Auto QA (Java)", () -> {
            vacancyJavaQaPage.openPage();
        });
        step("Проверяем переход по клику на страницу описания компании ", () -> {
            vacancyJavaQaPage.checkCompanyClickPage();
        });

        step("Проверяем присутствие описания компании на странице", () -> {
            vacancyJavaQaPage.checkCompanyClickPageNew();
        });
    }
}

