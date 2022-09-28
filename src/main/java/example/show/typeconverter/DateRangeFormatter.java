package example.show.typeconverter;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.Formatter;
import org.thymeleaf.expression.Calendars;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static javax.print.attribute.standard.MediaSizeName.D;

public class DateRangeFormatter implements Formatter<Map<String,LocalDate>> {
    @Override
    public Map<String,LocalDate> parse(String text, Locale locale) throws ParseException {
        String[] dateRange = text.split("~");
        LocalDate startDate = LocalDate.parse(dateRange[0],
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(dateRange[1],
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Map<String, LocalDate> date = new HashMap<>();
        date.put("startDate", startDate);
        date.put("endDate", endDate);
        return date;
    }

    @Override
    public String print(Map<String,LocalDate> object, Locale locale) {
        return null;
    }
}
