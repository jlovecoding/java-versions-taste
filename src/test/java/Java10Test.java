import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.copyOf;
import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.*;

public class Java10Test {

    //local variable type inference
    @Test
    public void shouldInferVariableType() {
        var list = new ArrayList<String>();
        assertEquals(ArrayList.class, list.getClass());
    }

    //copyOf for Collections
    @Test
    public void shouldCopyCollection() {
        //given
        List<String> list = List.of("a", "b", "c");
        //when && then
        assertArrayEquals(new String[]{"a", "b", "c"}, copyOf(list).toArray());
    }


    //Collectors.toUnmodifiableXXXX
    @Test
    public void shouldCollectIntoUnmodifiableCollection() {
        List<String> unmodifiableList = of("a", "b").collect(toUnmodifiableList());
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.add("new letter"));
    }

}
