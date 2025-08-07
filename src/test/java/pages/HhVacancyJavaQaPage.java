package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HhVacancyJavaQaPage {
    private final SelenideElement

            namePage = $(".bloko-header-section-1"),
            pageCompany = $(".g-user-content p").$("strong");

    private final ElementsCollection
            link = $$("div[data-qa=vacancy-company] span");


    public HhVacancyJavaQaPage openPage() {
        open("/vacancy/120964676?query=Автоматизация+тестирования+java&hhtmFrom=vacancy_search_list");
        executeJavaScript("$('.footer-counters').remove()");

        return this;
    }
@Step("Проверяем наименования страницы (вакансии)")
    public void checkResultNamePage() {
        namePage.shouldHave(text("Auto QA (Java)"));

    }

    @Step("Проверяем , что видно рейтинг ")
    public void checkStarsCompanyPage() {
        if ($("[data-qa='bloko-notification']").exists()) {
            $("[data-qa='bloko-notification'] [data-qa='close-button']").click();
            $("[data-qa='employer-reviews-stars'] [class*='star']")
                    .shouldBe(visible, Duration.ofSeconds(10));
        }
    }
    @Step("Проверяем переход по клику на страницу описания компании ")
    public HhVacancyJavaQaPage checkCompanyClickPage() {
        link.findBy(exactText("Offer Now"))
                .click();
        return this;
    }
    @Step("Проверяем присутствие описания компании на странице")
    public void checkCompanyClickPageNew() {
        pageCompany.shouldHave(exactText("Offer Now"));

    }
}
