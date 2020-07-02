
import java.util.Random;

/**
 * @author lgh on 2020/5/30 9:45
 * @description
 */
public class Tank implements Moveable {
    @Override
    public void move(String s) {
        System.out.println("tank is moving" + s);
//        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(System.currentTimeMillis());
    }
}
