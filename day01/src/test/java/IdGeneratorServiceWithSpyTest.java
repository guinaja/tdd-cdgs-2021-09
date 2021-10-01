import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpyRandom extends Random {
    private int  count = 0;


    @Override
    public int nextInt(int bound) {
        count++;
        return 6;
    }
    public void verify(int expectCount) {
        assertEquals(count, expectCount);
    }
}

public class IdGeneratorServiceWithSpyTest {
    @Test
    public void getData() {
        IdGeneratorService service = new IdGeneratorService();
        SpyRandom spy = new SpyRandom();
        service.setRandom(spy);
        String result = service.getData();
        spy.verify(1);
    }
}