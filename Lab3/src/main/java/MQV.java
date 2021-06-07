import java.math.BigInteger;

public class MQV {

    private final BigInteger p;
    private final BigInteger q;
    private final BigInteger g;
    private final BigInteger a;
    private final BigInteger A;
    private final BigInteger x;
    private final BigInteger X;

    public MQV(BigInteger p, BigInteger q, BigInteger g, BigInteger a) {
        this.p = p;
        this.q = q;
        this.g = g;
        this.a = a;
        A = g.modPow(a, p);
        x = util.bigIntRandom(BigInteger.TWO, q.subtract(BigInteger.TWO));
        X = g.modPow(x, p);
    }

    public BigInteger getPublicKey() {
        return X;
    }

    public BigInteger[] getStaticKeyPair() {
        return new BigInteger[]{a, A};
    }

    public BigInteger generateSecret(BigInteger Y, BigInteger B) {
        int l = (int) Math.ceil(q.bitLength() / 2.0);
        BigInteger X_ = X.mod(BigInteger.TWO.pow(l))
                .add(BigInteger.TWO.pow(l));
        BigInteger Y_ = Y.mod(BigInteger.TWO.pow(l))
                .add(BigInteger.TWO.pow(l));
        BigInteger S = x.add(X_.multiply(a)).mod(q);
        BigInteger t = Y.multiply(B.modPow(Y_, p)).mod(p);
        BigInteger Z = t.modPow(S, p);
        return Z;
    }

}
