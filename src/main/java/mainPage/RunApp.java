package mainPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static helperClasses.Helper.timer;

/**
 * Created by Sharikov Pavel on 02.12.2017.
 */
public class RunApp extends Application {

    //TODO: Прикрутить логгер и запись всех действий в txt файл
    //TODO: Реализовать метод initConfig() для чтения всех конфигов с пропертей и их инициализации
    //TODO: Быть может потом создать отдельный клас со всеми полями, и на каждую команду создается экземляр этого класса

    private static Long stamp1;
    private static Long stamp2;
    private static Long stamp3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainPage/mainPage.fxml"));
        primaryStage.setTitle("Goods Rental Timer");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        // Устанавливаем иконку приложения
        primaryStage.getIcons().add(new Image(mainPage.RunApp.class.getResourceAsStream("/images/statistics.png")));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
        stamp1 = timer.getTimeHHMMSS(timer.getTimeStamp());
        Thread.sleep(61900);
        stamp2 = timer.getTimeHHMMSS(timer.getTimeStamp());
        stamp3 = stamp2 - stamp1;
        System.out.println("Stamp3: " + stamp3);
        System.out.println("Прошло минут: " + (double) stamp3 / 60000);
    }
}