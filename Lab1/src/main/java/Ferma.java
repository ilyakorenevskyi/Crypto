import java.math.BigInteger;
import java.util.Random;

public class Ferma {
    public Ferma(){}

    public static boolean checkPrime(BigInteger n, int k) {
        for (int i = 0; i < k; i++) {
            BigInteger a = util.bigIntRandom(BigInteger.ONE,n);
            a = a.modPow(n.subtract(BigInteger.ONE), n);
            if (!a.equals(BigInteger.ONE))
                return false;
        }
        return true;
    }



}