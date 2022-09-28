package example.typeconverter;

import example.show.typeconverter.DateRangeFormatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FormatterTest {

    DateRangeFormatter formatter = new DateRangeFormatter();

    @Test
    void dataRangeFormatter() throws ParseException {
        String dateRange = "2022-09-02~2022-10-05";
        Map<String, LocalDate> date = new HashMap<>();
        date.put("startDate", LocalDate.of(2022, 9, 2));
        date.put("endDate", LocalDate.of(2022, 10, 5));
        Assertions.assertThat(formatter.parse(dateRange, Locale.KOREA))
                .isEqualTo(date);
    }
}
