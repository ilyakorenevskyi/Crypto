import java.math.BigInteger;
import java.util.Objects;

public class Montgomery {

    private final BigInteger modulus;
    private final BigInteger modulusInv;
    private final BigInteger R;
    private final BigInteger RInv;
    private final int RBits;

    public Montgomery(BigInteger modulus) {
        Objects.requireNonNull(modulus);
        if (!modulus.testBit(0) || modulus.compareTo(BigInteger.ONE) <= 0)
            throw new IllegalArgumentException("Modulus must be an odd number at least 3");
        this.modulus = modulus;
        RBits = modulus.bitLength() + 1;
        R = BigInteger.ONE.shiftLeft(RBits);
        BigInteger[] gcd = Euclid.gcd(R, modulus);
        RInv = R.modInverse(modulus);
        modulusInv = modulus.modInverse(R).negate();
    }


    public BigInteger multiply(BigInteger a, BigInteger b) {
        BigInteger a_ = a.shiftLeft(RBits).mod(modulus);
        BigInteger b_ = b.shiftLeft(RBits).mod(modulus);
        BigInteger t = a_.multiply(b_);
        BigInteger u = t.add((t.multiply(modulusInv).mod(R)).multiply(modulus));
        u = u.shiftRight(RBits);
        if (u.compareTo(modulus) > 0)
            return u.subtract(modulus);
        else return u;
    }


    public BigInteger pow(BigInteger a, BigInteger e) {
        BigInteger a_ = a.shiftLeft(RBits).mod(modulus);
        BigInteger x_ = BigInteger.ONE.shiftLeft(RBits).mod(modulus);
        String bitE = e.toString(2);
        for (int i = 0; i < e.bitLength(); i++) {
            x_ = multiply(x_, x_);
            if(bitE.charAt(i) == '1'){
                x_ = multiply(x_,a_);
            }

        }
        return multiply(x_, BigInteger.ONE);
    }
}
