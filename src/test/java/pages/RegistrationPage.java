package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends TestBase {
    private final SelenideElement firstNameInput = $("#firstName"); //
    private final SelenideElement lastNameInput = $("#lastName");  //
    private final SelenideElement userEmailInput = $("#userEmail");  //
    private final SelenideElement userGenderWrapper = $("#genterWrapper");
    private final SelenideElement userPhoneNumberInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement userCurrentAddressInput = $("#currentAddress");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement pictureUploader = $("#uploadPicture");
    private final SelenideElement dropListState = $("#state");
    private final SelenideElement dropListCity = $("#city");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement checkResultNegative = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('.Google-Ad').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }


    public RegistrationPage setGender(String value) {
        userGenderWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserPhoneNumber(String value) {
        userPhoneNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesWrapper.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        pictureUploader.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage selectState(String state) {
        dropListState.click();
        dropListState.$(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        dropListCity.click();
        dropListCity.$(byText(city)).click();
        return this;
    }

 public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;

    }

    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent.getResultTable(key, value);

        return this;
    }

    public void checkResultTableIsNotVisible() {
        checkResultNegative.shouldNotBe(visible);

    }


}