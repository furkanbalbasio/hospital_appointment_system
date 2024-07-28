package org.has.utility.enums;

public enum AppointmentHours {
    HOUR_08_00("08:00"), HOUR_08_15("08:15"), HOUR_08_30("08:30"), HOUR_08_45("08:45"),
    HOUR_09_00("09:00"), HOUR_09_15("09:15"), HOUR_09_30("09:30"), HOUR_09_45("09:45"),
    HOUR_10_00("10:00"), HOUR_10_15("10:15"), HOUR_10_30("10:30"), HOUR_10_45("10:45"),
    HOUR_11_00("11:00"), HOUR_11_15("11:15"), HOUR_11_30("11:30"), HOUR_11_45("11:45"),
    HOUR_12_00("12:00"), HOUR_12_15("12:15"), HOUR_12_30("12:30"), HOUR_12_45("12:45"),
    HOUR_13_00("13:00"), HOUR_13_15("13:15"), HOUR_13_30("13:30"), HOUR_13_45("13:45"),
    HOUR_14_00("14:00"), HOUR_14_15("14:15"), HOUR_14_30("14:30"), HOUR_14_45("14:45"),
    HOUR_15_00("15:00"), HOUR_15_15("15:15"), HOUR_15_30("15:30"), HOUR_15_45("15:45"),
    HOUR_16_00("16:00"), HOUR_16_15("16:15"), HOUR_16_30("16:30"), HOUR_16_45("16:45");
    private final String time;

    AppointmentHours(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public static AppointmentHours fromString(String time) {
        for (AppointmentHours appointmentHour : AppointmentHours.values()) {
            if (appointmentHour.getTime().equals(time)) {
                return appointmentHour;
            }
        }
        throw new IllegalArgumentException("No constant with text " + time + " found");
    }
    @Override
    public String toString() {
        return time;
    }
}
