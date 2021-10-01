import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Random6 extends Random {
    @Override
    public int nextInt(int bound) {
        return 6;
    }
}

public class IdGeneratorServiceTest {
    @Test
    public void getData() {
        IdGeneratorService service = new IdGeneratorService();
        Random stub = new Random6();
        service.setRandom(stub);
        String result = service.getData();
        assertEquals("CODE6", result);
    }
}