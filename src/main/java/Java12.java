import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.*;

public class Java12 {

    //switch expressions
    public static int getWeekDayNumberOfLetters(final WeekDay weekDay) {
        return switch (weekDay) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> throw new RuntimeException("Asking about number of letters of WEDNESDAY" +
                    " is not allowed");
        };
    }

    enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    //Collectors.teeing
    public static double calculateAverage(final Double... numbers) {
        return Stream.of(numbers).collect(
                teeing(
                        summingDouble(i -> i),
                        counting(),
                        (sum, n) -> sum / n));
    }

    //String.indent
    public static String indentText(final String text, final int numberOfLeading) {
        return text.indent(numberOfLeading);
    }

    //String.transform
    public static int squareText(final String a) {
        return a.transform(n -> parseInt(n) * parseInt(n));
    }

}
