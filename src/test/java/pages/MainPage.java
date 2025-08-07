package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement

            logo = $(".t228__logo"),
            language = $("a[href='http://offer-now.org']");
    private final ElementsCollection
            menuList = $$(".t-menu__list");


    public MainPage openPage() {
        open("https://offer-now.ru/");
        return this;
    }

    public void checkLogoPage() {
        logo.shouldHave(text("OfferNow"));

    }

    public void checkMenuPage() {
        menuList.shouldHave(
                exactTexts("Главная Работодателю Работа у нас Контакты Вопрос / Ответ")
        );
    }

    @Step("Клик по ссылке смены языка ")
    public MainPage checkLanguageSwitchPage() {
        language.click();
        return this;
    }

    @Step("Проверяем что страница отображена на ENG языке ")

    public void checkMenuEngPage() {
        menuList.shouldHave(
                exactTexts("Home Work Contacts"));
    }
}