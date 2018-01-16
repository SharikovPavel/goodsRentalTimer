package helperClasses;

import java.util.LinkedHashMap;

/**
 * Created by Sharikov Pavel on 04.12.2017.
 */
public class Helper {

    /**
     * Объект класса Timer для получения времени в нужных форматах
     */
    public static final Timer timer = new Timer();

    /**
     * hashMap для хранения имени команды с объектом класса созданного специально для нее
     * и содержащим всю необходимую информацию.
     * String - имя команды
     * Command - объект класса Command содержащий всю информацию, в том числе о начале аренды и т.д.
     */
    public LinkedHashMap<String, Command> commandInfo = new LinkedHashMap<String, Command>();
}
