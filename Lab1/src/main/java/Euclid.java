import java.math.BigInteger;

public class Euclid {
    public static BigInteger[] gcd (BigInteger a, BigInteger b){
        BigInteger[] res = new BigInteger[3];
        BigInteger x;
        BigInteger y;
        if(a.compareTo(BigInteger.ZERO) ==0){
            x = BigInteger.ZERO ;
            y = BigInteger.ONE ;
            return new BigInteger[]{b, x, y};
        }
        BigInteger[] prev_res = gcd(b.divideAndRemainder(a)[1],a);
        x = prev_res[2].subtract(prev_res[1].multiply(b.divideAndRemainder(a)[0]));
        y = prev_res[1];
        prev_res[1] = x;
        prev_res[2] = y;
        return prev_res;
    }

}
