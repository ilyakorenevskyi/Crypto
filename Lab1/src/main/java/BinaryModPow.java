import java.math.BigInteger;
import java.security.InvalidParameterException;

public class BinaryModPow {

    public BinaryModPow(){}

    public static BigInteger modPow(BigInteger x, BigInteger pow, BigInteger m)
    {
        if (m.compareTo(BigInteger.ZERO) <= 0) throw new IllegalArgumentException("Modulus must be greater than 0");
        if (pow.compareTo(BigInteger.ZERO) < 0) return modPow(x.modInverse(m), pow.negate(), m);

        BigInteger res = BigInteger.ONE;
        BigInteger a = x;
        BigInteger n = pow;

        while (!n.equals(BigInteger.ZERO))
        {
            if (n.and(BigInteger.ONE).equals(BigInteger.ONE)) { //check if odd
                res = res.multiply(a).mod(m);
                n= n.subtract(BigInteger.ONE);
            }
           else{
               a = a.multiply(a).mod(m);
               n = n.shiftRight(1);
            }
        }
        return res;
    }

}