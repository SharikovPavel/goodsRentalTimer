package helperClasses;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Properties;

/**
 * Created by Sharikov Pavel on 04.12.2017.
 */
public class Helper {

    public static Properties props;
    private static InputStreamReader isr;
    private static final String PATH_APP_PROPERTIES = System.getProperty("user.dir")
            + "/src/main/resources/config.properties";

    /**
     * Инициализируем конфиг-файлы приложения
     *
     * @throws Exception
     */
    public static void initProps() throws Exception {
        props = new Properties();
        try {
            isr = new InputStreamReader(new FileInputStream(new File(PATH_APP_PROPERTIES)),
                    "UTF8");
            props.load(isr);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Ошибка. Не удалось прочитать файл конфигураций");
        }
    }

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
    private static LinkedHashMap<String, Command> commandInfo = new LinkedHashMap<String, Command>();

    /**
     * Метод запоминающщий все информацию по аренде игры определенной команды в hashMap для дальнейшего использования в отчете
     *
     * @param nameCommand     имя команды
     * @param allFieldCommand объект класса Command хранящий всю инфу о команде
     */
    public static void fillCommandInfo(String nameCommand, Command allFieldCommand) {
        commandInfo.put(nameCommand, allFieldCommand);
    }
}