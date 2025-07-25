package pages;

import com.codeborne.selenide.*;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;




public class HhVacancyJavaQaPage {
    private final SelenideElement

            textH = $("[data-qa=\"title-container\"]"),
            namePage = $(".bloko-header-section-1"),
            pageCompany = $(".g-user-content p").$("strong"),
            transition = $("a[data-qa='link'][href='https://offer-now.ru/']"),
            pageCompanyOfSite = $(".tn-atom"),
            favorites = $("[data-qa=\"vacancy-body-mark-favorite_false\"]");
    private final ElementsCollection
            link = $$("div[data-qa=vacancy-company] span");


    public HhVacancyJavaQaPage openPage() {
        open("/vacancy/120964676?query=Автоматизация+тестирования+java&hhtmFrom=vacancy_search_list");
        executeJavaScript("$('.footer-counters').remove()");

        return this;
    }

    public void checkResultNamePage() {
        namePage.shouldHave(text("Auto QA (Java)"));

    }




    public HhVacancyJavaQaPage clickFavorites() {
        favorites.click();

        return this;
    }


    public void checkFormReg() {
        textH.shouldHave(text("Вход"));

    }


    public void checkStarsCompany() {
        // 1. Проверяем наличие уведомления и закрываем его, если есть
        if ($("[data-qa='bloko-notification']").exists()) {
            // Вариант A: Закрыть кнопкой (если есть)
            $("[data-qa='bloko-notification'] [data-qa='close-button']").click();

            $("[data-qa='employer-reviews-stars'] [class*='star']")
                    .shouldBe(visible, Duration.ofSeconds(10));
        }
    }

    public HhVacancyJavaQaPage checkCompanyClickPage() {
        link.findBy(exactText("Offer Now"))
                .click();
        return this;
    }

    public void checkCompanyClickPageNew() {
        pageCompany.shouldHave(exactText("Offer Now"));

    }
}
