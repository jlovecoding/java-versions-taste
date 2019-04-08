import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Java12Test {

    @Test
    public void shouldGetWeekDayNumberOfLetters() {
        assertEquals(6, Java12.getWeekDayNumberOfLetters(Java12.WeekDay.SUNDAY));
        assertEquals(7, Java12.getWeekDayNumberOfLetters(Java12.WeekDay.TUESDAY));
        assertEquals(8, Java12.getWeekDayNumberOfLetters(Java12.WeekDay.THURSDAY));
        assertThrows(RuntimeException.class, () -> Java12.getWeekDayNumberOfLetters(Java12.WeekDay.WEDNESDAY),
                "RuntimeException was expected");
    }

    @Test
    public void shouldCalculateAverage() {
        assertEquals(6, Java12.calculateAverage(1d, 4d, 13d));
    }

    @Test
    public void shouldIndentText() {
        assertEquals("   this is\n   a story of\n    a man...\n",
                Java12.indentText("this is\na story of\n a man...", 3));
    }

    @Test
    public void shouldSquareText() {
        assertEquals(49, Java12.squareText("7"));
    }
}