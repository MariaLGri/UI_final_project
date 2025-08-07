package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WorkFormWithUsPage {

    private final SelenideElement
            text = $("#rec455038024"),
            joinTeamButton = $("a.t580__btn[href='/work_form']"),
            nameField = $("#input_1495646533382"),
            emailField = $("#input_1495646567135"),
            phoneField = $("#input_1495646545048"),
            subjectField = $("#input_1657387875485"),
            messageField = $("#input_1657388032559"),
            submitButton = $(".t-submit"),
            successMessage = $("#tildaformsuccesspopuptext-new");

    @Step("Открытие страницы")
    public WorkFormWithUsPage openPage() {
        open("https://offer-now.ru/work");
        return this;
    }
    @Step("Проверяем текст")
    public void checkTextPage() {
        text.shouldHave(text("На данный момент у нас открыты следующие вакансии!"));

    }
    @Step("Клик по кнопке 'Хочу в команду'")
    public WorkFormWithUsPage workOpenForm() {
        joinTeamButton
                .shouldBe(visible)
                .click();
        return this;
    }
    @Step("Заполняем Имя")
    public WorkFormWithUsPage fillName(String name) {
        nameField.setValue(name);
        return this;
    }
    @Step("Заполняем email")
    public WorkFormWithUsPage fillEmail(String email) {
        emailField.setValue(email);
        return this;
    }
    @Step("Заполняем номер телефона")
    public WorkFormWithUsPage fillPhone(String phone) {
        phoneField.setValue(phone);
        return this;
    }
    @Step("Заполняем ссылку")
    public WorkFormWithUsPage fillSubject(String subject) {
        subjectField.setValue(subject);
        return this;
    }
    @Step("Заполняем комментарий")
    public WorkFormWithUsPage fillMessage(String message) {
        messageField.setValue(message);
        return this;
    }
    @Step("Отправляяем форму")
    public WorkFormWithUsPage submitForm() {
        submitButton.click();
        return this;
    }
    @Step("Проверяем отправку формы")
    public void verifySuccessMessage() {
        successMessage.shouldBe(visible)
                .shouldHave(text("Данные успешно отправлены."));
    }


}
