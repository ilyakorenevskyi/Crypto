import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String str = "I feel only pain";
        System.out.println(str.length());
        MARS mars = new MARS(new int[]{12345435, 35654, 265432, 543356});
        System.out.println(new String(mars.encrypt(str.getBytes(StandardCharsets.UTF_8))));
        String res = new String(mars.decrypt(mars.encrypt(str.getBytes(StandardCharsets.UTF_8))));
        System.out.println(res);
    }
}
