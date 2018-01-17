package helperClasses;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.apache.http.protocol.HTTP.USER_AGENT;

/**
 * Created by Sharikov Pavel on 02.12.2017.
 */
public class Timer {

    /**
     * Отправляем get запрос на сайт получаем timestamp даты и времени
     *
     * @return Возвращаем ответ сервера на наш запрос
     * @throws Exception
     */
    public Long getTimeStamp() throws Exception {
        String url = "https://time100.ru/api.php";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("Ответ с time100.ru: " + response.toString() + " секунд");
        return Long.decode(response.toString());
    }

    //TODO: Разобраться, может совсем и не надо 2 метода. Может достаточно делать (timeStamp1-timeStamp2)*1000 и делать formattedDate

    /**
     * Получаем время в необходимом нам формате: HH:mm:ss в Long
     *
     * @param responseTime timeStamp получаенный от сервера
     * @return
     */
    public Long getTimeHHMMSS(long responseTime) {
        Date date = new Date(responseTime * 1000L); // *1000 получаем миллисекунды
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // какой формат нужен, выбераем
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3")); // если нужно даем таймзон
        String formattedDate = sdf.format(date);
        System.out.println("Формат даты: " + formattedDate);
        Long timeLong = sdf.getCalendar().getTime().getTime();
        System.out.println("Милисекунды: " + timeLong);
        return timeLong;
    }

    /**
     * Получаем время в необходимом нам формате: HH:mm:ss в String
     *
     * @param responseTime timeStamp получаенный от сервера
     * @return
     */
    public String getTimeStringHHMMSS(long responseTime) {
        Date date = new Date(responseTime * 1000L); // *1000 получаем миллисекунды
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); // какой формат нужен, выбераем
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+3")); // если нужно даем таймзон
        String formattedDate = sdf.format(date);
        return formattedDate;
    }
}