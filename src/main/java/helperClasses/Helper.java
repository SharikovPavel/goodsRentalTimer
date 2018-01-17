package helperClasses;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * Created by Sharikov Pavel on 04.12.2017.
 */
public class Helper {

    /**
     * Инициализируем сцену и все что с ней связанно
     *
     * @param primaryStage
     * @throws IOException
     */
    public void initScene(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("mainPage/mainPage.fxml"));
        primaryStage.setTitle("Goods Rental Timer");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        // Устанавливаем иконку приложения
        primaryStage.getIcons().add(new Image(mainPage.RunApp.class.getResourceAsStream("/images/statistics.png")));
        primaryStage.show();
    }

    /**
     * Объект класса Timer для получения времени в нужных форматах
     */
    public static Timer timer = new Timer();

    /**
     * hashMap для хранения имени команды с объектом класса созданного специально для нее
     * и содержащим всю необходимую информацию.
     * String - имя команды
     * Command - объект класса Command содержащий всю информацию, в том числе о начале аренды и т.д.
     */
    public static LinkedHashMap<String, Command> commandInfo = new LinkedHashMap<String, Command>();
}