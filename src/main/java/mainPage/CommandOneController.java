package mainPage;

import helperClasses.Command;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
public class CommandOneController {

    Command team;

    private final static long MINUTES = 60000;
    private final static String STYLE_BORDER_RED = "-fx-border-color: red; -fx-border-radius: 5;";
    private final static String STYLE_BORDER_BASE = "-fx-border-color: base;";

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
    private TextField currentTimeCommand_1;

    @FXML
    public void startTimerCommand() throws Exception {
        if (!checkTextFieldOfNullable()) {
            return;
        }
        // Создаем объект команды
        team = new Command();
        // Выключаем кнопку Старт таймер
        startTimerCommand_1.setDisable(true);
        // Получаем текущее время, запоминаем его в объект команды
        team.setTimeStampStartTheGame(timer.getTimeStamp());
        // Показываем время начала игры в соответствующем поле
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

    @FXML
    public void updateTimerCommand() throws Exception {
        // Обрубать до 2-х цифр после запятой, а лучше, реализовать округление, меньше 5, больше 5
        if (!startTimeCommand_1.isDisabled()) {
            return;
        }
        Long currentTime = timer.getTimeHHMMSS(timer.getTimeStamp()) - timer.getTimeHHMMSS(team.getTimeStampStartTheGame());
        currentTimeCommand_1.setText(String.valueOf((double) currentTime / MINUTES));
    }

    /**
     * Подсветка полей ввода красной рамкой, если при нажатии кнопки запуска таймера, они не заполненны
     *
     * @return
     */
    private boolean checkTextFieldOfNullable() {
        int cnt = 0;

        if (nameCommand_1.getText().isEmpty()) {
            nameCommand_1.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            nameCommand_1.setStyle(STYLE_BORDER_BASE);
        }

        if (gameCommand_1.getText().isEmpty()) {
            gameCommand_1.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            gameCommand_1.setStyle(STYLE_BORDER_BASE);
        }

        if (amountPeopleCommand_1.getText().isEmpty()) {
            amountPeopleCommand_1.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            amountPeopleCommand_1.setStyle(STYLE_BORDER_BASE);
        }

        try {
            Long.valueOf(amountPeopleCommand_1.getText());
        } catch (NumberFormatException e) {
            amountPeopleCommand_1.setStyle(STYLE_BORDER_RED);
            cnt++;
        }

        return (cnt > 0) ? false : true;
    }
}