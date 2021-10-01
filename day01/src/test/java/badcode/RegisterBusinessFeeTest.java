package badcode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegisterBusinessFeeTest {
    @ParameterizedTest
    @CsvSource({
            "0,500",
            "1,500",
            "2,250",
            "3,250",
            "4,100",
            "5,100",
            "8,50",
            "9,50",
            "10,0",
    })
    public void getFee(int exp, int fee) {
        RegisterBusiness business = new RegisterBusiness();
        int actualFee = business.getFee(exp);
        assertEquals(fee, actualFee);
    }
}
