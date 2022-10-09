package introduction;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class Demo {

//    4 yra lyginis skaičius
//    Dabar nera 19 valanda

    @Test
    public void testIfNumber4IsEven() {
        // duomenys
        int actualImput = 4;
        int expectedResults = 0;
        int actualResults;

        // testo veiksmas
        actualResults = actualImput % 2;

        // palyginimas
        Assert.assertEquals(actualResults, expectedResults);
    }

    @Test
    public void testIfNumber5IsNotEven() {
        // duomenys
        int actualImput = 5;
        int expectedResults = 1;
        int actualResults;

        // testo veiksmas
        actualResults = actualImput % 2;

        // palyginimas
        Assert.assertTrue(
                actualResults == expectedResults,
                "Actual: " + actualResults + ", Expected: " + expectedResults);
    }

    @Test
    public void testIfTimeNowIsNot19Hour() {
        // duomenys
        int notExpextedTime = 19;
        int actualTime;
        boolean isSameTime;

        // test veikmas
        actualTime = LocalTime.now().getHour();

        isSameTime = notExpextedTime == actualTime; // expected false

        // palyginimas
        Assert.assertFalse(
                isSameTime,
                String.format("Expected: %s, Acutal: %s", notExpextedTime, actualTime)
        );

    }

}
