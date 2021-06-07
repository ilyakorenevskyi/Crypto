import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigInteger;

public class MQVTest {
    @Test
    public void secretKeyMatch(){
        MQV alice = new MQV(BigInteger.valueOf(283),BigInteger.valueOf(47),BigInteger.valueOf(60),BigInteger.valueOf(24));
        MQV bob = new MQV(BigInteger.valueOf(283),BigInteger.valueOf(47),BigInteger.valueOf(60),BigInteger.valueOf(7));
        BigInteger Zb = bob.generateSecret(alice.getPublicKey(),alice.getStaticKeyPair()[1]);
        BigInteger Za = alice.generateSecret(bob.getPublicKey(),bob.getStaticKeyPair()[1]);
        assertEquals(0,Za.compareTo(Zb));
    }

}
