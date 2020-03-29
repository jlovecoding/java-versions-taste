import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

public class Java14Test {

  @Test
  public void shouldMatchPatternInInstanceOf() {
    //Given
    Function<Object, Integer> numberParser =
        o -> {
          if (o instanceof String s && s.startsWith("num#")){
            return parseInt(s.substring("num#".length()));
          }
          throw new RuntimeException("Non valid input");
        };

    Object formattedNumber = "num#123";

    //When && Then
    assertEquals(valueOf(123), numberParser.apply(formattedNumber));

  }

  @Test
  public void shouldCreateRecord() {
    //Given
    record Engine (String enginename){
    }
    ;
    record Car (String model,int year, Engine engine){
    }
    ;

    //When
    Car car = new Car("ibiza", 2000, new Engine("1600cc"));

    //Then
    assertEquals("ibiza", car.model);
    assertNotEquals("ibizaa", car.model);
    assertEquals(2000, car.year);
    assertEquals(new Engine("1600cc"), car.engine);
    assertEquals(new Car("ibiza", 2000, new Engine("1600cc")), car);
  }

}
