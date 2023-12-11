package de.bergmanninfotech.joggingtrackerapi.web;

public class RunControllerTestHelper {
    private RunControllerTestHelper() {
        throw new UnsupportedOperationException();
    }

    public static String startRunValid() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"startLatitude\": 40.177433,\n" +
                "  \"startLongitude\": 44.507597,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunUserIdAbsent() {
        return "{\n" +
                "  \"userId\": null,\n" +
                "  \"startLatitude\": 40.177433,\n" +
                "  \"startLongitude\": 44.507597,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunUserIdInvalid() {
        return "{\n" +
                "  \"userId\": \"asd\",\n" +
                "  \"startLatitude\": 40.177433,\n" +
                "  \"startLongitude\": 44.507597,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunUserIdNegative() {
        return "{\n" +
                "  \"userId\": -10,\n" +
                "  \"startLatitude\": 40.177433,\n" +
                "  \"startLongitude\": 44.507597,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunLatAbsent() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"startLongitude\": 44.507597,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunLatInvalid() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"startLatitude\": -100,\n" +
                "  \"startLongitude\": 44.507597,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunLonAbsent() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"startLatitude\": -100,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunLonInvalid() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"startLatitude\": 40.177433,\n" +
                "  \"startLongitude\": 190,\n" +
                "  \"startDateTime\": \"2023-12-09T17:00:00Z\"\n" +
                "}";
    }

    public static String startRunStartDateTimeAbsent() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"startLatitude\": 40.177433,\n" +
                "  \"startLongitude\": 179,\n" +
                "  \"startDateTime\": null\n" +
                "}";
    }

    public static String startRunStartDateTimeInvalid() {
        return "{\n" +
                "  \"userId\": 1,\n" +
                "  \"startLatitude\": 40.177433,\n" +
                "  \"startLongitude\": -70,\n" +
                "  \"startDateTime\": \"2023-ASD-09T17:00:00Z\"\n" +
                "}";
    }

    public static String finishRunValid() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-12-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": 40.172965,\n" +
                "  \"finishLongitude\": 44.511341,\n" +
                "  \"distance\": 500\n" +
                "}";
    }

    public static String finishRunValidWithoutDistance() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-12-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": 40.172965,\n" +
                "  \"finishLongitude\": 44.511341\n" +
                "}";
    }

    public static String finishRunValidWithNullableDistance() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-12-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": 40.172965,\n" +
                "  \"finishLongitude\": 44.511341,\n" +
                "  \"distance\": null\n" +
                "}";
    }

    public static String finishRunFinishDateTimeAbsent() {
        return "{\n" +
                "  \"finishDateTime\": null,\n" +
                "  \"finishLatitude\": 40.172965,\n" +
                "  \"finishLongitude\": 44.511341\n" +
                "}";
    }

    public static String finishRunFinishDateTimeInvalid() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-ASD-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": 40.172965,\n" +
                "  \"finishLongitude\": 44.511341\n" +
                "}";
    }

    public static String finishRunFinishLatAbsent() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-12-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": null,\n" +
                "  \"finishLongitude\": 44.511341\n" +
                "}";
    }

    public static String finishRunFinishLatInvalid() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-12-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": -500,\n" +
                "  \"finishLongitude\": 44.511341\n" +
                "}";
    }

    public static String finishRunFinishLonAbsent() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-12-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": 40.172965,\n" +
                "}";
    }

    public static String finishRunFinishLonInvalid() {
        return "{\n" +
                "  \"finishDateTime\": \"2023-12-09T17:03:00Z\",\n" +
                "  \"finishLatitude\": 40.172965,\n" +
                "  \"finishLongitude\": 190.123\n" +
                "}";
    }
}
