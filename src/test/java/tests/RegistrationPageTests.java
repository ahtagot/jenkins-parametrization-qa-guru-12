package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static data.TestData.*;
import static io.qameta.allure.Allure.step;

public class RegistrationPageTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    String firstName = generateFirstName();
    String lastName = generateLastName();
    String emailAddress = generateUserEmail();
    String phoneNumber = generatePhoneNumber();
    String userAddress = generateUserAddress();
    String gender = generateGender();
    String userDayOfBirth = generateDayOfBirth();
    String userMonthOfBirth = generateMonthOfBirth();
    String userYearOfBirth = generateUserYearOfBirth();
    String hobbie = generateUserHobbies();
    String subject = generateSubject();
    String pictureName = generateUserPicture();
    String state = generateState();
    String city = generateCity();

    @Test
    @DisplayName("Check registration with all fields filled")
    @Tag("demoqa_run")
    void registrationPageTestAllFieldsFilled() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open Registration page", () -> registrationPage.openPage());
        step("Fill registration form fields", () ->
                registrationPage.setFirstName(firstName)
                        .setLastName(lastName)
                        .setUserEmail(emailAddress)
                        .setGender(gender)
                        .setUserPhoneNumber(phoneNumber)
                        .setUserCurrentAddress(userAddress)
                        .setDateOfBirth(userDayOfBirth, userMonthOfBirth, userYearOfBirth)
                        .setUserSubjects(subject)
                        .setHobbies(hobbie)
                        .uploadPicture(pictureName)
                        .selectState(state)
                        .selectCity(city));

        step("Submit form", () -> registrationPage.clickSubmitButton());

        // Results verification
        step("Verify results", () -> registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", emailAddress)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", pictureName)
                .checkResult("Address", userAddress)
                .checkResult("State and City", state + " " + city));

    }

    @Test
    @DisplayName("Check registration with filled necessary fields only")
    @Tag("smoke_test")
    void registrationPageTestRequiredFieldsOnly() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open Registration page", () -> registrationPage.openPage());
        step("Fill necessary form fields", () -> registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserPhoneNumber(phoneNumber));

        step("Submit form", () -> registrationPage.clickSubmitButton());

        // Results verification
        step("Verify results", () -> registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber));

    }

    @Test
    @DisplayName("Check registration with necessary fields filled partly")
    @Tag("demoqa_run")
    void registrationPageNegativeTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open Registration page", () -> registrationPage.openPage());
        step("Fill necessary form fields partly", () -> registrationPage.setFirstName("")
                .setLastName(lastName)
                .setGender(gender)
                .setUserPhoneNumber(phoneNumber));
        step("Submit form", () -> registrationPage.clickSubmitButton());

        // Results verification
        step("Verify results", () -> registrationPage.checkResultTableIsNotVisible());

    }
}
