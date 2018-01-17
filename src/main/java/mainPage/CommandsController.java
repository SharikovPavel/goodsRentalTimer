package mainPage;

import helperClasses.Command;
import helperClasses.Helper;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static helperClasses.Helper.timer;

/**
 * @author p.sharikov
 * <p>
 * nameCommand_1 - Имя
 * gameCommand_1 - Название игры
 * amountPeopleCommand_1 - Количество человек
 * fixFirstHourCommand_1 - Фиксированный первый час игры
 * startTimerCommand_1 - Кнопка Старт таймер
 * startTimeCommand_1 - Начало в (время начала игры)
 * updateTimerCommand_1 - Прошедшее время аренды игры на текущий момент. Кнопка Обновить
 * currentTimeCommand_1 - Прошло времени игры
 * stopTimerCommand_1 - Кнопка Стоп таймер
 * allMinCommand_1 - полное количество прошедших минут с начала аренды (после стоп таймера)
 * totalCostCommand_1 - Итоговая стоимость аренды игры
 * clearAllFieldCommand_1 - Очистить все поля, связанные с данной командой
 * command_1 - Номер команды
 **/
public class CommandsController {

    @FXML
    private Button startTimerCommand_1;

    @FXML
    private TextField nameCommand_1;

    @FXML
    private TextField gameCommand_1;

    @FXML
    private TextField amountPeopleCommand_1;

    @FXML
    private TextField startTimeCommand_1;

    @FXML
    public void startTimerCommand() throws Exception {
        // Создаем объект команды
        Command team = new Command();

        // Получаем текущее время, запоминаем его в объект команды
        team.setTimeStampStartTheGame(timer.getTimeStamp());

        // Показываем вреия начала игры в соответствующем поле
        startTimeCommand_1.setText(timer.getTimeStringHHMMSS(team.getTimeStampStartTheGame()));

        // Делаем поля ввода неактивными
        nameCommand_1.setEditable(false);
        gameCommand_1.setEditable(false);
        amountPeopleCommand_1.setEditable(false);

        // Запоминаем в объект команды данные с введенных полей
        team.setNameCommand(nameCommand_1.getText());
        team.setGameCommand(gameCommand_1.getText());
        team.setAmountPeopleCommand(amountPeopleCommand_1.getText());
    }
}