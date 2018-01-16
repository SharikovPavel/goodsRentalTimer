package mainPage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Sharikov Pavel on 02.12.2017.
 */
public class RunApp extends Application {

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
        Timer tm = new Timer();
        stamp1 = tm.sendGet();
        Thread.sleep(61900);
        stamp2 = tm.sendGet();
        stamp3 = stamp2 - stamp1;
        System.out.println("Stamp3: " + stamp3);
        System.out.println("Прошло минут: " + (double) stamp3 / 60000);
    }
}