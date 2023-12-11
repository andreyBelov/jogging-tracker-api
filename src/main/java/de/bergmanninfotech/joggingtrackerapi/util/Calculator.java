package de.bergmanninfotech.joggingtrackerapi.util;

import de.bergmanninfotech.joggingtrackerapi.entity.Run;

import java.time.Duration;
import java.time.Instant;

public final class Calculator {

    public static final int EARTH_RADIUS = 6371;
    public static final float METERS_PER_SEC_TO_KM_PER_HOUR_RATIO = 3.6f;

    /**
     * This method isn’t very accurate when calculating long distances
     * It treats the Earth as a perfect sphere and maps the sphere to a rectangular grid
     */
    public static double calculateDistanceInKm(double lat1, double lon1, double lat2, double lon2) {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);
        double distance = Math.sqrt(x * x + y * y) * EARTH_RADIUS;

        return distance;
    }

    public static Long calculateDistanceInMeters(double lat1, double lon1, double lat2, double lon2) {
        return Math.round(calculateDistanceInKm(lat1, lon1, lat2, lon2) * 1000);
    }

    public static Float calculateAvgSpeedInKmPerHour(Long distance, Instant startDateTime, Instant finishDateTime) {
        long time = Duration.between(startDateTime, finishDateTime).toSeconds();
        return calculateAvgSpeedInKmPerHour(distance, time);
    }

    public static Float calculateAvgSpeedInKmPerHour(Long distance, Long timeInSeconds) {
        return ((float)distance / timeInSeconds) * METERS_PER_SEC_TO_KM_PER_HOUR_RATIO;
    }

    private Calculator() { throw new UnsupportedOperationException(); }
}
