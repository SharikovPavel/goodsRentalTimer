package mainPage;

import helperClasses.Command;
import helperClasses.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import static helperClasses.Helper.timer;

/**
 * @author p.sharikov
 **/
public class CommandOneController {

    Command team;

    private final static long MINUTES = 60000;
    private final static String EMPTY_FIELD = "";
    private final static String STYLE_BORDER_RED = "-fx-border-color: red; -fx-border-radius: 5;";
    private final static String STYLE_BORDER_BASE = "-fx-border: base;";

    /**
     * Кнопка Старт таймер
     */
    @FXML private Button startTimerCommand_1;

    @FXML
    /**
     * Имя команды
     */
    private TextField nameCommand_1;

    /**
     * Название игры
     */
    @FXML private TextField gameCommand_1;

    /**
     * Количество человек
     */
    @FXML private TextField amountPeopleCommand_1;

    /**
     * Поле "Начало в" (время начала игры)
     */
    @FXML private TextField startTimeCommand_1;

    /**
     * Прошло времени игры (текстовое поле)
     */
    @FXML private TextField currentTimeCommand_1;

    /**
     * Фиксированный первый час игры
     */
    @FXML private CheckBox fixFirstHourCommand_1;

    /**
     * Полное количество прошедших минут с начала аренды (после стоп таймера)
     */
    @FXML private TextField allMinuteCommand_1;

    /**
     * Итоговая стоимость аренды игры
     */
    @FXML private TextField totalCostCommand_1;

    /**
     * Кнопка стоп таймер
     */
    @FXML private Button stopTimerCommand_1;

    /**
     * Прошедшее время аренды игры на текущий момент. Кнопка Обновить
     */
    @FXML private Button updateTimerCommand_1;

    /**
     * Очистить все поля, связанные с данной командой
     */
    @FXML private Button clearAllFieldCommand_1;

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
        // Делаем поля ввода и кнопки неактивными
        nameCommand_1.setEditable(false);
        gameCommand_1.setEditable(false);
        amountPeopleCommand_1.setEditable(false);
        fixFirstHourCommand_1.setDisable(true);
        clearAllFieldCommand_1.setDisable(true);
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

    @FXML
    public void stopTimerCommand() throws Exception {
        team.setTimeStampEndTheGame(timer.getTimeStamp());
        Long allMinuteCommand = timer.getTimeHHMMSS(team.getTimeStampEndTheGame() - team.getTimeStampStartTheGame()) / MINUTES;
        allMinuteCommand_1.setText(String.valueOf((double) allMinuteCommand));

        // Реализовать проверку на фикс час и добавить округление
        Double totalCostCommand = Double.valueOf(team.getAmountPeopleCommand()) * (Double.valueOf(Helper.props.getProperty("pricePerMinute"))
        * allMinuteCommand);
        totalCostCommand_1.setText(String.valueOf(totalCostCommand));
        team.setTotalCostCommand(totalCostCommand);

        stopTimerCommand_1.setDisable(true);
        updateTimerCommand_1.setDisable(true);
        clearAllFieldCommand_1.setDisable(false);
        Helper.fillCommandInfo(team.getNameCommand() + "_" + team.getGameCommand(), team);
    }

    @FXML
    public void clearAllFieldCommand() {
        //Чистим все поля
        startTimeCommand_1.setText(EMPTY_FIELD);
        nameCommand_1.setText(EMPTY_FIELD);
        gameCommand_1.setText(EMPTY_FIELD);
        amountPeopleCommand_1.setText(EMPTY_FIELD);
        allMinuteCommand_1.setText(EMPTY_FIELD);
        totalCostCommand_1.setText(EMPTY_FIELD);
        currentTimeCommand_1.setText(EMPTY_FIELD);
        //Включаем все кнопки и поля
        nameCommand_1.setEditable(true);
        gameCommand_1.setEditable(true);
        amountPeopleCommand_1.setEditable(true);
        fixFirstHourCommand_1.setDisable(false);
        updateTimerCommand_1.setDisable(false);
        fixFirstHourCommand_1.setSelected(false);
        startTimerCommand_1.setDisable(false);
        stopTimerCommand_1.setDisable(false);
        //Чистим объект класса
        team = null;
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