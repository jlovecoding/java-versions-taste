import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

public class Java11Test {

    //var to be used when declaring the formal parameters of implicitly typed lambda expressions.
    //when using annotations use var is the only way
    private static BiFunction<String, Integer, String> repeatText() {
        return (@NonNull var text, @NonNull var numRepetitions) -> text.repeat(numRepetitions);
    }

    @Test
    public void shouldRepeatText() {
        assertEquals("abcabcabc", repeatText().apply("abc", 3));
    }

    @Test
    public void shouldNotRepeatTextWhenNullText() {
        assertThrows(NullPointerException.class, () -> repeatText().apply(null, 3));
    }

    //String methods
    @Test
    public void testStringMethods() {
        assertTrue("      ".isBlank());
        assertArrayEquals(new String[]{"a", "b", "c"}, "a\nb\nc".lines().toArray());
        assertEquals("abcabcabc", "abc".repeat(3));
        assertEquals("abc", "   abc ".strip());
        assertEquals("abc  ", "    abc  ".stripLeading());
        assertEquals("    abc", "    abc  ".stripTrailing());
    }

    //Negation of predicate
    @Test
    public void shouldNegatePredicate() {
        //Given
        Predicate<String> predicate = s -> s.startsWith("j");
        List<String> names = List.of("john", "charly", "juliette", "mike");

        //When
        List<String> filteredNames = names.stream().filter(not(predicate)).collect(toList());

        //Then
        assertEquals(2, filteredNames.size());
        assertEquals("charly", filteredNames.get(0));
        assertEquals("mike", filteredNames.get(1));
    }

    //Optional is Empty
    @Test
    public void shouldBeEmpty() {
        assertTrue(empty().isEmpty());
        assertFalse(of("something").isEmpty());
    }


}
