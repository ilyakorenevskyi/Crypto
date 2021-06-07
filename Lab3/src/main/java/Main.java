import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        MQV alice = new MQV(BigInteger.valueOf(283),BigInteger.valueOf(47),BigInteger.valueOf(60),BigInteger.valueOf(24));
        MQV bob = new MQV(BigInteger.valueOf(283),BigInteger.valueOf(47),BigInteger.valueOf(60),BigInteger.valueOf(7));
        BigInteger Zb = bob.generateSecret(alice.getPublicKey(),alice.getStaticKeyPair()[1]);
        BigInteger Za = alice.generateSecret(bob.getPublicKey(),bob.getStaticKeyPair()[1]);
        System.out.println(Za.toString()+" " + Zb.toString());
    }
}
