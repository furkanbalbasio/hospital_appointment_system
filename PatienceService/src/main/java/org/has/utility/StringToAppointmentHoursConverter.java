package org.has.utility;

import org.has.utility.enums.AppointmentHours;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAppointmentHoursConverter implements Converter<String, AppointmentHours> {
    @Override
    public AppointmentHours convert(String source) {
        return AppointmentHours.fromString(source);
    }
}
