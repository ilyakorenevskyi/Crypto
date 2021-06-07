import java.math.BigInteger;
import java.util.Random;

public class MillerRabin {

    public MillerRabin(){}


    public static boolean checkPrime(BigInteger n, int k) {

        if (n.equals(BigInteger.ONE))
            return false;
        if (n.compareTo(BigInteger.valueOf(3)) <= 0)
            return true;

        int s = 0;
        BigInteger d = n.subtract(BigInteger.ONE);

        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
            s++;
        }

        for (int i = 0; i < k; i++) {
            BigInteger a = util.bigIntRandom(BigInteger.TWO, n.subtract(BigInteger.TWO));
            BigInteger x = a.modPow(d, n);

            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE)))
                continue;
            boolean check = true;
            for (int j = 0; j < s; j++) {
                x = x.modPow(BigInteger.TWO, n);
                if (x.equals(BigInteger.ONE))
                    return false;
                if (x.equals(n.subtract(BigInteger.ONE))) {
                    check = false;
                    break;
                }
            }
            if(check) return false;
        }
        return true;
    }



}