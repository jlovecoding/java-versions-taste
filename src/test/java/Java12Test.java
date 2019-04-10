import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Java12Test {

    //switch expressions
    private static int getWeekDayNumberOfLetters(final WeekDay weekDay) {
        return switch (weekDay) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> throw new RuntimeException("Asking about number of letters of WEDNESDAY is not allowed");
        };
    }

    enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    @Test
    public void shouldGetWeekDayNumberOfLetters() {
        assertEquals(6, getWeekDayNumberOfLetters(WeekDay.SUNDAY));
        assertEquals(7, getWeekDayNumberOfLetters(WeekDay.TUESDAY));
        assertEquals(8, getWeekDayNumberOfLetters(WeekDay.THURSDAY));
        assertThrows(RuntimeException.class, () -> getWeekDayNumberOfLetters(WeekDay.WEDNESDAY),
                "RuntimeException was expected");
    }

    //Collectors.teeing
    private static double calculateAverage(final Double... numbers) {
        return Stream.of(numbers).collect(
                teeing(
                        summingDouble(i -> i),
                        counting(),
                        (sum, n) -> sum / n));
    }

    @Test
    public void shouldCalculateAverage() {
        assertEquals(6, calculateAverage(1d, 4d, 13d));
    }

    //String.indent
    @Test
    public void shouldIndent() {
        //given
        String text = "this is\na story of\n a man...";
        int numberOfLeading = 3;

        //when
        String indented = text.indent(numberOfLeading);

        assertEquals("   this is\n   a story of\n    a man...\n", indented);
    }

    //String.transform
    @Test
    public void shouldTransform() {
        //given
        String number = "7";

        //when
        int transformed = number.transform(n -> parseInt(n) * parseInt(n));

        //then
        assertEquals(49, transformed);
    }


}