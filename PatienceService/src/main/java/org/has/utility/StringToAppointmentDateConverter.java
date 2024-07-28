package org.has.utility;

import org.has.utility.enums.AppointmentDate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToAppointmentDateConverter implements Converter<String, AppointmentDate> {
    @Override
    public AppointmentDate convert(String source) {
        return AppointmentDate.fromString(source);
    }
}