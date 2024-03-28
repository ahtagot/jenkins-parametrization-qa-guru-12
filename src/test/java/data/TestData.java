package data;

import com.github.javafaker.Faker;


public class TestData {


    private static final Faker faker = new Faker();

    public static String generateUserHobbies() {
         return  String.valueOf(faker.options().option("Sports", "Reading", "Music"));
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateGender() {
        return String.valueOf(faker.options().option("Male", "Female", "Other"));
    }


    public static String generatePhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);

    }

    public static String generateUserAddress() {
        return faker.address().fullAddress();

    }

    public static String generateUserYearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1900, 2023));
    }

    public static String generateDayOfBirth() {
        return String.valueOf(faker.number().numberBetween(1, 28));

    }
    public static String generateMonthOfBirth() {
        return String.valueOf(faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"));

    }

    public static String generateSubject() {
        return String.valueOf(faker.options().option("Accounting", "Arts", "Biology", "Chemistry",
                "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History",
                "Maths", "Physics", "Social Studies"));
    }

    public static String generateUserPicture() {
        return String.valueOf(faker.options().option("dagon.png", "landscape.jpg", "planet.png"));
    }

    static String userState;
    static String userCity;

    public static String generateState() {
        return userState = (faker.options().option("NCR", "Haryana", "Rajasthan", "Uttar Pradesh"));
    }


    public static String generateCity() {
        String generateNCRCity = faker.options().option("Delhi", "Gurgaon", "Noida"),
                generateHaryanaCity = faker.options().option("Karnal", "Panipat"),
                generateRajasthanCity = faker.options().option("Jaipur", "Jaiselmer"),
                generateUttarPradeshCity = faker.options().option("Agra", "Lucknow", "Merrut");

        switch (userState) {
            case "NCR" -> userCity = generateNCRCity;
            case "Haryana" -> userCity = generateHaryanaCity;
            case "Rajasthan" -> userCity = generateRajasthanCity;
            default -> userCity = generateUttarPradeshCity;
        }
        return userCity;


    }
}