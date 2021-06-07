import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MontgomeryTest {
    @Test
    public void montgomeryModPowTest(){
        Random rand = new Random();
        for(int i = 0;i<100;i++) {
            BigInteger a = new BigInteger(512, rand);
            BigInteger n = new BigInteger(512, rand);
            BigInteger m = new BigInteger(512, rand);
            while (m.mod(BigInteger.TWO).compareTo(BigInteger.ZERO)==0){
                m = new BigInteger(512, rand);
            }
            Montgomery montgomery = new Montgomery(m);
            assertEquals(a.modPow(n,m),montgomery.pow(a,n));
        }
    }
}
