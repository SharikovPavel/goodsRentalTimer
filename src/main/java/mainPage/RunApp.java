package mainPage;

import helperClasses.Helper;
import javafx.application.Application;
import javafx.stage.Stage;

import static helperClasses.Helper.timer;

/**
 * Created by Sharikov Pavel on 02.12.2017.
 */
public class RunApp extends Application {

    //http://www.cyberforum.ru/java-gui/thread1394821.html много одинаковых кнопок в хэшмапу или массив и слушать, какая из них была нажата (listener)

    //TODO: Прикрутить логгер и запись всех действий в txt файл

    private static Long stamp1;
    private static Long stamp2;
    private static Long stamp3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Helper.class.newInstance().initScene(primaryStage);
    }

    public static void main(String[] args) throws Exception {
        Helper.initProps();
        launch(args);

        // Тест метода работы с временем timeStamp
        stamp1 = timer.getTimeHHMMSS(timer.getTimeStamp());
        System.out.println("Stamp1: " + stamp1 + " милисекунд");
        Thread.sleep(61900);
        stamp2 = timer.getTimeHHMMSS(timer.getTimeStamp());
        System.out.println("Stamp2: " + stamp2 + " милисекунд");
        stamp3 = stamp2 - stamp1;
        System.out.println("Stamp3: " + stamp3 + " милисекунд");
        System.out.println("Прошло минут: " + (double) stamp3 / 60000);
    }
}