import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {

    @Test
    @DisplayName("ตัวแรกเป็น [ ,input [1,5] , result = true")
    public void case01() {
        MyRange range = new MyRange("[1,5]");
        boolean result = range.startWithInclude();
        assertTrue(result);
    }

    @Test
    @DisplayName("ตัวแรกเป็น [ input (1,5] , result = false ")
    public void case02() {
        MyRange range = new MyRange("(1,5]");
        boolean result = range.startWithInclude();
        assertFalse(result);
    }

    @Test
    @DisplayName("ตัวเลขเริ่มต้น เป็น 1 , input = [1,5] , result = 1 ")
    public void case03() {
        MyRange range = new MyRange("[1,5]");
        int result = range.getStart();
        assertEquals(1,result);
    }

    @Test
    @DisplayName("ตัวเลขเริ่มต้น เป็น 1 , input = (1,5] , result = 2 ")
    public void case04() {
        MyRange range = new MyRange("(1,5]");
        int result = range.getStart();
        assertEquals(2,result);
    }

    @Test
    @DisplayName("ตัวเลขสุดท้าย เป็น ], input = (1,5] , result = true ")
    public void case05() {
        MyRange range = new MyRange("(1,5]");
        boolean result = range.endWithInclude();
        assertTrue(result);
    }

    @Test
    @DisplayName("ตัวเลขสุดท้าย เป็น ], input = (1,5) , result = false ")
    public void case06() {
        MyRange range = new MyRange("(1,5)");
        boolean result = range.endWithInclude();
        assertFalse(result);
    }

    @Test
    @DisplayName("ตัวเลขสุดท้าย เป็น ), input = (1,5) , result = true ")
    public void case07() {
        MyRange range = new MyRange("(1,5)");
        boolean result = range.endWithExclude();
        assertTrue(result);
    }

    @Test
    @DisplayName("ตัวเลขสุดท้าย เป็น 5 , input = [1,5] , result = 5 ")
    public void case08() {
        MyRange range = new MyRange("[1,5]");
        int result = range.getEnd();
        assertEquals(5,result);
    }

    @Test
    @DisplayName("ตัวเลขสุดท้าย เป็น 4 , input = [1,5) , result = 4 ")
    public void case09() {
        MyRange range = new MyRange("[1,5)");
        int result = range.getEnd();
        assertEquals(4,result);
    }


    @Test
    @DisplayName("input = [1,5] , result = 1,2,3,4,5")
    public void case101(){
        MyRange range = new MyRange("[1,5]");
        String result = range.getRange();
        assertEquals("1,2,3,4,5",result);

    }

    @Test
    @DisplayName("input = [1,5) , result = 1,2,3,4")
    public void case102(){
        MyRange range = new MyRange("[1,5)");
        String result = range.getRange();
        assertEquals("1,2,3,4",result);

    }

    @Test
    @DisplayName("input = (1,5] , result = 2,3,4,5")
    public void case103(){
        MyRange range = new MyRange("(1,5]");
        String result = range.getRange();
        assertEquals("2,3,4,5",result);
    }

    @Test
    @DisplayName("input = (1,5) , result = 2,3,4")
    public void case104(){
        MyRange range = new MyRange("(1,5)");
        String result = range.getRange();
        assertEquals("2,3,4",result);
    }


}