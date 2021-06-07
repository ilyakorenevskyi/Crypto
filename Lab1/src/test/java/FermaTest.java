import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FermaTest {
    @Test
    public void primeTest() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            assertTrue(Ferma.checkPrime(BigInteger.probablePrime(512, rand), 100));
        }
    }

    @Test
    public void notPrimeTest() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            BigInteger toCheck = new BigInteger(512, rand);
            if (!toCheck.isProbablePrime(100)) {
                assertFalse(Ferma.checkPrime(toCheck, 100));
            }
        }
    }
}
