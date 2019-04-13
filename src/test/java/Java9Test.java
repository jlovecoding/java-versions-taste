import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Java9Test {

    // Convenience Factory Methods for Collections
    @Test
    public void shouldCreateCollections() {
        //Given && When
        Map<Integer, String> map = Map.of(1, "cat", 23, "dog", -1, "shark");
        //Then
        assertEquals(Set.of(1, 23, -1), map.keySet());
        assertThrows(UnsupportedOperationException.class, () -> map.put(0, ""));
    }

    //Streams methods
    @Test
    public void shouldTakeWhile() {
        //Given
        Stream<Integer> infiniteInts = Stream.iterate(0, i -> i + 1);
        //When
        Stream<Integer> result = infiniteInts.takeWhile(i -> i < 5);
        //Then
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, result.toArray());
    }

    @Test
    public void shouldDropWhile() {
        //Given
        Stream<Integer> finiteInts = Stream.iterate(0, i -> i < 10, i -> i + 1);
        //When
        Stream<Integer> result = finiteInts.dropWhile(i -> i < 5);
        //Then
        assertArrayEquals(new Integer[]{5, 6, 7, 8, 9}, result.toArray());
    }

    @Test
    public void shouldReturnOrderedStream() {
        //Given && When
        Stream<Integer> result = Stream.iterate(0, i -> i < 5, i -> i + 2);
        //Then
        assertArrayEquals(new Integer[]{0, 2, 4}, result.toArray());
    }

    //Optional methods
    @Test
    public void shouldDoSomethingWhenOptionalNotPresent() {
        // given
        List<String> names = new ArrayList<>();
        // when
        Optional.empty().ifPresentOrElse(value -> fail("optional should be empty, not contain value " + value),
                () -> names.add("john"));
        // then
        assertArrayEquals(new String[]{"john"}, names.toArray());
    }

    @Test
    public void shouldReturnOtherOptionalIfEmpty() {
        //given && when
        Optional<String> animal = Optional.of("dog")
                .filter(animal1 -> animal1.startsWith("c"))
                .or(() -> Optional.of("shark"));
        //then
        assertTrue(animal.isPresent());
        assertEquals("shark", animal.get());
    }

    @Test
    public void shouldReturnStream() {
        //Given && When && Then
        assertArrayEquals(new String[]{"car"}, Optional.of("car").stream().toArray());
    }
}
