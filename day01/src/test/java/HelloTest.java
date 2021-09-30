import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    @DisplayName("test on junit 5")
    public void case01() {
        Hello hello = new Hello();
        String result = hello.say("prayoon.su");
        assertEquals("Hello prayoon.su", result);
    }
}
