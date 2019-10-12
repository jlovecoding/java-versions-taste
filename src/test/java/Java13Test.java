import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java13Test {

    @Test
    public void shouldCreateTextBlock() {
        String textBlock = """
        this is
        a text
         block""";
        String expected = "this is\na text\n block";

        assertEquals(expected, textBlock);
    }

    @Test
    public void shouldCreateSwitchExpression() {
        Function<WeekDay, Integer> dayWeekNumLetters =
                dayOfWeek -> switch (dayOfWeek) {
                    case MONDAY:
                    case FRIDAY:
                    case SUNDAY:
                        yield 6;
                    case TUESDAY:
                        yield 7;
                    case THURSDAY:
                    case SATURDAY:
                        yield 8;
                    case WEDNESDAY:
                        yield 9;
                    default:
                        throw new IllegalStateException("Huh?: " + dayOfWeek);
                };

        assertEquals(Integer.valueOf(8), dayWeekNumLetters.apply(WeekDay.SATURDAY));
        assertEquals(Integer.valueOf(8), dayWeekNumLetters.apply(WeekDay.THURSDAY));

    }

    enum WeekDay {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
