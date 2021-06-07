import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Montgomery montgomery = new Montgomery(BigInteger.valueOf(253));
        System.out.println(montgomery.pow(BigInteger.valueOf(132414),BigInteger.valueOf(543321))+" "+BigInteger.valueOf(132414).modPow(BigInteger.valueOf(543321),BigInteger.valueOf(253)));
    }
}
