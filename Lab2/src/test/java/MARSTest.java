
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MARSTest {
    @Test
    public void wrongKeyLength(){
        assertThrows(IllegalArgumentException.class,()->new MARS(new byte[3]));
        assertThrows(IllegalArgumentException.class,()->new MARS(new byte[80]));
    }
    @Test
    public void encryptDecryptTest(){
        byte[] key = new byte[40];
        Random rand = new Random();
        for(int  i = 0; i<10;i++){
            rand.nextBytes(key);
        }
        byte[] data = new byte[32];
        for(int  i = 0; i<10 ;i++){
            rand.nextBytes(data);
        }
        MARS mars = new MARS(key);
        byte[] dec = mars.decrypt(mars.encrypt(data));
        assertArrayEquals(data,dec);

    }
}
