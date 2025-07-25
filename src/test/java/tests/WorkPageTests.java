package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.WorkFormWithUsPage;
import static io.qameta.allure.Allure.step;

@DisplayName("Автотесты для компании OFFER NOW, сайт компании, работа ")
@Owner("Гришина М.Л")
public class WorkPageTests extends TestBase{
    WorkFormWithUsPage workFormWithUsPage = new WorkFormWithUsPage();

    @Test
    @DisplayName("Проверка страницы 'Работа у нас', открытие, текст ")
    void vacancyCompanyTest() {
        step("Проверяем открытие стараницы ", () -> {
            workFormWithUsPage.openPage();
        });
        step("Проверяем наличие текста на странице", () -> {
            workFormWithUsPage.checkTextPage();
        });

    }

    @ParameterizedTest(name = "Тест формы")
    @CsvFileSource(resources = "/form_test_data.csv", numLinesToSkip = 1)
    public void testFormFillingWithCsv(String name, String phone, String email, String link, String comment) {
        step("Открываем страницу 'Работа у нас' ", () -> {
            workFormWithUsPage.openPage();
        });
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