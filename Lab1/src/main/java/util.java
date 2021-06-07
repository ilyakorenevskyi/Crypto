import java.math.BigInteger;
import java.util.Random;

public class util {
    public static BigInteger bigIntRandom(BigInteger lowerBound, BigInteger upperBound) {
        Random rand = new Random();
        BigInteger res;
        do { res = new BigInteger(upperBound.bitLength(), rand); } while (res.compareTo(lowerBound) < 0 || res.compareTo(upperBound) > 0);
        return res;
    }
}
