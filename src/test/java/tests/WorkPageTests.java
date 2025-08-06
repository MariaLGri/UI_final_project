package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.WorkFormWithUsPage;
import org.junit.jupiter.api.Nested;

import static io.qameta.allure.Allure.step;

@DisplayName("Автотесты OFFER NOW - Раздел 'Работа у нас'")
@Epic("WEB UI Тестирование")
@Feature("Карьера в OFFER NOW")
@Story("Функционал страницы 'Работа у нас'")

public class WorkPageTests extends TestBase {
    WorkFormWithUsPage workFormWithUsPage = new WorkFormWithUsPage();

    @Test
    @Owner("Гришина М.Л")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка страницы 'Работа у нас', открытие, текст ")
    void vacancyCompanyTest() {

        step("Проверяем наличие текста на странице", () -> {
            workFormWithUsPage.checkTextPage();
        });

    }


    @Nested
    @DisplayName("Тестирование формы 'Хочу в команду'")
    @Story("Функционал формы обратной связи")
    @Owner("Гришина М.Л")
    class FormTests {
        @ParameterizedTest(name = "Тест заполнения формы с данными: {0}, {1}, {2}")
        @Severity(SeverityLevel.CRITICAL)
        @DisplayName("Проверка отправки формы с различными данными")
        @Description("Параметризованный тест проверки формы обратной связи с различными входными данными")
        @CsvFileSource(resources = "/form_test_data.csv", numLinesToSkip = 1)
        public void testFormFillingWithCsv(String name, String phone, String email, String link, String comment) {

            step("Проверяем заполнение формы 'Хочу в команду' ", () -> {
                workFormWithUsPage
                        .workOpenForm()
                        .fillName(name)
                        .fillEmail(email)
                        .fillPhone(phone)
                        .fillSubject(link)
                        .fillMessage(comment)
                        .submitForm()
                        .verifySuccessMessage();

            });
        }
    }
}