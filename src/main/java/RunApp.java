import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Sharikov Pavel on 02.12.2017.
 */
public class RunApp {
    private static Long stamp1;
    private static Long stamp2;
    private static Long stamp3;

    public static void main(String[] args) throws Exception {
        Timer tm = new Timer();
        stamp1 = tm.sendGet();
        Thread.sleep(350000);
        stamp2 = tm.sendGet();
        stamp3 = stamp2 - stamp1;
        System.out.println("Stamp3: " + stamp3);
        System.out.println("Прошло минут: " + (double) stamp3/60000);
    }
}