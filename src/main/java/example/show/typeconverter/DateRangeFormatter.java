package example.show.typeconverter;

import org.springframework.format.Formatter;

import java.sql.Date;
import java.text.ParseException;
import java.util.*;


public class DateRangeFormatter implements Formatter<Map<String, Date>> {
    @Override
    public Map<String, Date> parse(String text, Locale locale) throws ParseException {
        String[] dateRange = text.split("~");
        Date startDate = Date.valueOf(dateRange[0]);
        Date endDate = Date.valueOf(dateRange[1]);

        Map<String, Date> date = new HashMap<>();
        date.put("startDate", startDate);
        date.put("endDate", endDate);
        return date;
    }
    @Override
    public String print(Map<String, Date> object, Locale locale) {
        return null;
    }
}
