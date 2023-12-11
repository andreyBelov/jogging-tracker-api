package de.bergmanninfotech.joggingtrackerapi.web;

public class UserControllerTestHelper {
    private UserControllerTestHelper() {
        throw new UnsupportedOperationException();
    }

    public static String validCreationRequest() {
        return "{\n" +
                "  \"firstName\": \"Andrey\",\n" +
                "  \"lastName\": \"Beloborodov\",\n" +
                "  \"birthDate\": \"1992-06-20T21:00:00Z\",\n" +
                "  \"gender\": \"MALE\"\n" +
                "}";
    }

    public static String firstNameAbsent() {
        return "{\n" +
                "  \"firstName\": null,\n" +
                "  \"lastName\": \"Beloborodov\",\n" +
                "  \"birthDate\": \"1992-06-20T21:00:00Z\",\n" +
                "  \"gender\": \"MALE\"\n" +
                "}";
    }

    public static String lastNameAbsent() {
        return "{\n" +
                "  \"firstName\": \"Andrey\",\n" +
                "  \"lastName\": null,\n" +
                "  \"birthDate\": \"1992-06-20T21:00:00Z\",\n" +
                "  \"gender\": \"MALE\"\n" +
                "}";
    }

    public static String birthDateAbsent() {
        return "{\n" +
                "  \"firstName\": \"Andrey\",\n" +
                "  \"lastName\": \"Beloborodov\",\n" +
                "  \"birthDate\": null,\n" +
                "  \"gender\": \"MALE\"\n" +
                "}";
    }

    public static String birthDateInvalid() {
        return "{\n" +
                "  \"firstName\": \"Andrey\",\n" +
                "  \"lastName\": \"Beloborodov\",\n" +
                "  \"birthDate\": \"1992-Invalid\",\n" +
                "  \"gender\": \"MALE\"\n" +
                "}";
    }

    public static String genderAbsent() {
        return "{\n" +
                "  \"firstName\": \"Andrey\",\n" +
                "  \"lastName\": \"Beloborodov\",\n" +
                "  \"birthDate\": \"1992-06-20T21:00:00Z\",\n" +
                "  \"gender\": null\n" +
                "}";
    }

    public static String genderInvalid() {
        return "{\n" +
                "  \"firstName\": \"Andrey\",\n" +
                "  \"lastName\": \"Beloborodov\",\n" +
                "  \"birthDate\": \"1992-06-20T21:00:00Z\",\n" +
                "  \"gender\": \"ASD\"\n" +
                "}";
    }

    public static String invalidJson() {
        return "{ INVALID_JSON }";
    }


}
