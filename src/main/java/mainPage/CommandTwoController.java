package mainPage;

import helperClasses.Command;
import helperClasses.Helper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static helperClasses.Helper.timer;

/**
 * @author p.sharikov
 **/
public class CommandTwoController {

    Command team;

    private final static long MINUTES = 60000;
    private final static String EMPTY_FIELD = "";
    private final static String STYLE_BORDER_RED = "-fx-border-color: red; -fx-border-radius: 5;";
    private final static String STYLE_BORDER_BASE = "-fx-border: base;";

    List<Button> buttonsStart = new ArrayList<>();

    /**
     * Кнопка Старт таймер
     */
    @FXML private Button startTimerCommand_1;
    @FXML private Button startTimerCommand_2;
    @FXML private Button startTimerCommand_3;
    @FXML private Button startTimerCommand_4;
    @FXML private Button startTimerCommand_5;
    @FXML private Button startTimerCommand_6;
    @FXML private Button startTimerCommand_7;
    @FXML private Button startTimerCommand_8;
    @FXML private Button startTimerCommand_9;
    @FXML private Button startTimerCommand_10;
    @FXML private Button startTimerCommand_11;
    @FXML private Button startTimerCommand_12;

    /**
     * Имя команды
     */
    @FXML private TextField nameCommand_1;
    @FXML private TextField nameCommand_2;
    @FXML private TextField nameCommand_3;
    @FXML private TextField nameCommand_4;
    @FXML private TextField nameCommand_5;
    @FXML private TextField nameCommand_6;
    @FXML private TextField nameCommand_7;
    @FXML private TextField nameCommand_8;
    @FXML private TextField nameCommand_9;
    @FXML private TextField nameCommand_10;
    @FXML private TextField nameCommand_11;
    @FXML private TextField nameCommand_12;

    /**
     * Название игры
     */
    @FXML private TextField gameCommand_1;
    @FXML private TextField gameCommand_2;
    @FXML private TextField gameCommand_3;
    @FXML private TextField gameCommand_4;
    @FXML private TextField gameCommand_5;
    @FXML private TextField gameCommand_6;
    @FXML private TextField gameCommand_7;
    @FXML private TextField gameCommand_8;
    @FXML private TextField gameCommand_9;
    @FXML private TextField gameCommand_10;
    @FXML private TextField gameCommand_11;
    @FXML private TextField gameCommand_12;

    /**
     * Количество человек
     */
    @FXML private TextField amountPeopleCommand_1;
    @FXML private TextField amountPeopleCommand_2;
    @FXML private TextField amountPeopleCommand_3;
    @FXML private TextField amountPeopleCommand_4;
    @FXML private TextField amountPeopleCommand_5;
    @FXML private TextField amountPeopleCommand_6;
    @FXML private TextField amountPeopleCommand_7;
    @FXML private TextField amountPeopleCommand_8;
    @FXML private TextField amountPeopleCommand_9;
    @FXML private TextField amountPeopleCommand_10;
    @FXML private TextField amountPeopleCommand_11;
    @FXML private TextField amountPeopleCommand_12;

    /**
     * Поле "Начало в" (время начала игры)
     */
    @FXML private TextField startTimeCommand_1;
    @FXML private TextField startTimeCommand_2;
    @FXML private TextField startTimeCommand_3;
    @FXML private TextField startTimeCommand_4;
    @FXML private TextField startTimeCommand_5;
    @FXML private TextField startTimeCommand_6;
    @FXML private TextField startTimeCommand_7;
    @FXML private TextField startTimeCommand_8;
    @FXML private TextField startTimeCommand_9;
    @FXML private TextField startTimeCommand_10;
    @FXML private TextField startTimeCommand_11;
    @FXML private TextField startTimeCommand_12;

    /**
     * Прошло времени игры (текстовое поле)
     */
    @FXML private TextField currentTimeCommand_2;

    /**
     * Фиксированный первый час игры
     */
    @FXML private CheckBox fixFirstHourCommand_2;

    /**
     * Полное количество прошедших минут с начала аренды (после стоп таймера)
     */
    @FXML private TextField allMinuteCommand_2;

    /**
     * Итоговая стоимость аренды игры
     */
    @FXML private TextField totalCostCommand_2;

    /**
     * Кнопка стоп таймер
     */
    @FXML private Button stopTimerCommand_2;

    /**
     * Прошедшее время аренды игры на текущий момент. Кнопка Обновить
     */
    @FXML private Button updateTimerCommand_2;

    /**
     * Очистить все поля, связанные с данной командой
     */
    @FXML private Button clearAllFieldCommand_2;

    @FXML
    public void startTimerCommand() throws Exception {
        if (!checkTextFieldOfNullable()) {
            return;
        }
        // Создаем объект команды
        team = new Command();
        // Выключаем кнопку Старт таймер
        startTimerCommand_2.setDisable(true);
        // Получаем текущее время, запоминаем его в объект команды
        team.setTimeStampStartTheGame(timer.getTimeStamp());
        // Показываем время начала игры в соответствующем поле
        startTimeCommand_2.setText(timer.getTimeStringHHMMSS(team.getTimeStampStartTheGame()));
        // Делаем поля ввода и кнопки неактивными
        nameCommand_2.setEditable(false);
        gameCommand_2.setEditable(false);
        amountPeopleCommand_2.setEditable(false);
        fixFirstHourCommand_2.setDisable(true);
        clearAllFieldCommand_2.setDisable(true);
        // Запоминаем в объект команды данные с введенных полей
        team.setNameCommand(nameCommand_2.getText());
        team.setGameCommand(gameCommand_2.getText());
        team.setAmountPeopleCommand(amountPeopleCommand_2.getText());
    }

    @FXML
    public void updateTimerCommand() throws Exception {
        if (!startTimerCommand_2.isDisabled()) {
            return;
        }
        Long currentTime = timer.getTimeHHMMSS(timer.getTimeStamp()) - timer.getTimeHHMMSS(team.getTimeStampStartTheGame());
        currentTimeCommand_2.setText(roundingNumber((double) currentTime / MINUTES));
    }

    @FXML
    public void stopTimerCommand() throws Exception {
        team.setTimeStampEndTheGame(timer.getTimeStamp());
        Long allMinuteCommand = timer.getTimeHHMMSS(team.getTimeStampEndTheGame() - team.getTimeStampStartTheGame()) / MINUTES;
        allMinuteCommand_2.setText(String.valueOf((double) allMinuteCommand));

        // Реализовать проверку на фикс час и добавить округление
        Double totalCostCommand = Double.valueOf(team.getAmountPeopleCommand()) * (Double.valueOf(Helper.props.getProperty("pricePerMinute"))
        * allMinuteCommand);
        totalCostCommand_2.setText(String.valueOf(totalCostCommand));
        team.setTotalCostCommand(totalCostCommand);

        stopTimerCommand_2.setDisable(true);
        updateTimerCommand_2.setDisable(true);
        clearAllFieldCommand_2.setDisable(false);
        Helper.fillCommandInfo(team.getNameCommand() + "_" + team.getGameCommand(), team);
    }

    @FXML
    public void clearAllFieldCommand() {
        clearField();
        onAllFieldAndButton();
        //Чистим объект класса
        team = null;
    }

    /**
     * Очистка всех текстовых полей на форме
     */
    private void clearField() {
        //Чистим все поля
        startTimeCommand_2.setText(EMPTY_FIELD);
        nameCommand_2.setText(EMPTY_FIELD);
        gameCommand_2.setText(EMPTY_FIELD);
        amountPeopleCommand_2.setText(EMPTY_FIELD);
        allMinuteCommand_2.setText(EMPTY_FIELD);
        totalCostCommand_2.setText(EMPTY_FIELD);
        currentTimeCommand_2.setText(EMPTY_FIELD);
    }

    /**
     * Включение всех кнопок и полей
     */
    private void onAllFieldAndButton() {
        //Включаем все кнопки и поля
        nameCommand_2.setEditable(true);
        gameCommand_2.setEditable(true);
        amountPeopleCommand_2.setEditable(true);
        fixFirstHourCommand_2.setDisable(false);
        updateTimerCommand_2.setDisable(false);
        fixFirstHourCommand_2.setSelected(false);
        startTimerCommand_2.setDisable(false);
        stopTimerCommand_2.setDisable(false);
    }

    /**
     * Подсветка полей ввода красной рамкой, если при нажатии кнопки запуска таймера, они не заполненны
     *
     * @return
     */
    private boolean checkTextFieldOfNullable() {
        int cnt = 0;

        if (nameCommand_2.getText().isEmpty()) {
            nameCommand_2.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            nameCommand_2.setStyle(STYLE_BORDER_BASE);
        }

        if (gameCommand_2.getText().isEmpty()) {
            gameCommand_2.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            gameCommand_2.setStyle(STYLE_BORDER_BASE);
        }

        if (amountPeopleCommand_2.getText().isEmpty()) {
            amountPeopleCommand_2.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            amountPeopleCommand_2.setStyle(STYLE_BORDER_BASE);
        }

        try {
            Long.valueOf(amountPeopleCommand_2.getText());
        } catch (NumberFormatException e) {
            amountPeopleCommand_2.setStyle(STYLE_BORDER_RED);
            cnt++;
        }
        return (cnt > 0) ? false : true;
    }

    private String roundingNumber(Double number) {
        Double numberMinutes = Double.valueOf(number.toString().split("\\.")[0]);
        String stringNumberAfterDot = number.toString().split("\\.")[1];
            String stringNumberAfterDotLength = stringNumberAfterDot.substring(0,2);
            if (Double.valueOf(stringNumberAfterDotLength) > 50) {
                System.out.println("Кол-во минут прошло: " + number);
                System.out.println("Кол-во минут записано в поле: " + String.valueOf(++numberMinutes));
                return String.valueOf(++numberMinutes);
            } else {
                System.out.println("Кол-во минут прошло: " + number);
                System.out.println("Кол-во минут записано в поле: " + String.valueOf(numberMinutes));
                return String.valueOf(numberMinutes);
            }
    }
}