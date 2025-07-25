package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WorkFormWithUsPage {

    private final SelenideElement
            text = $("#rec455038024"),


    // переменные для проверки формы
    joinTeamButton = $("a.t580__btn[href='/work_form']"),
            nameField = $("#input_1495646533382"),

    emailField = $("#input_1495646567135"),

    phoneField = $("#input_1495646545048"),

    subjectField = $("#input_1657387875485"),

    messageField = $("#input_1657388032559"),

    submitButton = $(".t-submit"),

    successMessage = $("#tildaformsuccesspopuptext-new");


    public WorkFormWithUsPage openPage() {
        open("https://offer-now.ru/work");
        return this;
    }

    public void checkTextPage() {
        text.shouldHave(text("На данный момент у нас открыты следующие вакансии!"));

    }

    // методы для формы заполнения
    public WorkFormWithUsPage workOpenForm() {
        joinTeamButton
                .shouldBe(visible)
                .click();
        return this;
    }

    public WorkFormWithUsPage fillName(String name) {
        nameField.setValue(name);
        return this;
    }

    public WorkFormWithUsPage fillEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public WorkFormWithUsPage fillPhone(String phone) {
        phoneField.setValue(phone);
        return this;
    }

    public WorkFormWithUsPage fillSubject(String subject) {
        subjectField.setValue(subject);
        return this;
    }

    public WorkFormWithUsPage fillMessage(String message) {
        messageField.setValue(message);
        return this;
    }

    public WorkFormWithUsPage submitForm() {
        submitButton.click();
        return this;
    }

    public void verifySuccessMessage() {
        successMessage.shouldBe(visible)
                .shouldHave(text("Данные успешно отправлены."));
    }


}
