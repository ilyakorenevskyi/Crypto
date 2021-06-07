import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

public class BinaryModPowTest {
    @Test
    public void binaryModPowTest(){
        Random rand = new Random();
        for(int i = 0;i<100;i++) {
            BigInteger a = new BigInteger(512, rand);
            BigInteger n = new BigInteger(512, rand);
            BigInteger m = new BigInteger(512, rand);
            assertEquals(a.modPow(n,m),BinaryModPow.modPow(a,n,m));
        }
    }
}
