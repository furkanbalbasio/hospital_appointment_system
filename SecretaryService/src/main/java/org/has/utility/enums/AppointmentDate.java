package org.has.utility.enums;

public enum AppointmentDate {
    PAZARTESI("PAZARTESI"),
    SALI("SALI"),
    CARSAMBA("CARSAMBA"),
    PERSEMBE("PERSEMBE"),
    CUMA("CUMA");
    private final String date;

    AppointmentDate(String time) {
        this.date = time;
    }

    public String getDate() {
        return date;
    }
    public static AppointmentDate fromString(String date) {
        for (AppointmentDate appointmentDate : AppointmentDate.values()) {
            if (appointmentDate.getDate().equals(date)) {
                return appointmentDate;
            }
        }
        throw new IllegalArgumentException("No constant with text " + date + " found");
    }

    @Override
    public String toString() {
        return date;
    }

}
