import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

public class KaratsubaTest {
    @Test
    public void testKaratsubaMultiply(){
        Random rand = new Random();
        for(int i = 0;i<100;i++) {
            BigInteger a = new BigInteger(512, rand);
            BigInteger b = new BigInteger(512, rand);
            assertEquals(a.multiply(b),Karatsuba.multiply(a,b));
        }
    }
}
