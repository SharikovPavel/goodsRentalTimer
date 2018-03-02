package mainPage;

import helperClasses.Command;
import helperClasses.Helper;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static helperClasses.Helper.timer;

/**
 * @author p.sharikov
 **/
public class CommandTwoController {

    Command team;

    /**
     * Листы для хранения всех полей и кнопок, для быстрого доступа к ним
     */
    List<TextField> fieldNameCommand;
    List<TextField> fieldGameCommand;
    List<TextField> fieldAmountPeopleCommand;
    List<CheckBox> checkBoxFixFirstHourCommand;
    List<TextField> fieldStartTimeCommand;
    List<Button> buttonStartTimerCommand;
    List<Button> buttonUpdateTimerCommand;
    List<TextField> fieldCurrentTimeCommand;
    List<Button> buttonStopTimerCommand;
    List<TextField> fieldAllMinuteCommand;
    List<TextField> fieldTotalCostCommand;
    List<Button> buttonClearAllFieldCommand;

    private final static long MINUTES = 60000;
    private final static String EMPTY_FIELD = "";
    private final static String STYLE_BORDER_RED = "-fx-border-color: red; -fx-border-radius: 5;";
    private final static String STYLE_BORDER_BASE = "-fx-border: base;";

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
    @FXML private TextField currentTimeCommand_1;
    @FXML private TextField currentTimeCommand_2;
    @FXML private TextField currentTimeCommand_3;
    @FXML private TextField currentTimeCommand_4;
    @FXML private TextField currentTimeCommand_5;
    @FXML private TextField currentTimeCommand_6;
    @FXML private TextField currentTimeCommand_7;
    @FXML private TextField currentTimeCommand_8;
    @FXML private TextField currentTimeCommand_9;
    @FXML private TextField currentTimeCommand_10;
    @FXML private TextField currentTimeCommand_11;
    @FXML private TextField currentTimeCommand_12;

    /**
     * Фиксированный первый час игры
     */
    @FXML private CheckBox fixFirstHourCommand_1;
    @FXML private CheckBox fixFirstHourCommand_2;
    @FXML private CheckBox fixFirstHourCommand_3;
    @FXML private CheckBox fixFirstHourCommand_4;
    @FXML private CheckBox fixFirstHourCommand_5;
    @FXML private CheckBox fixFirstHourCommand_6;
    @FXML private CheckBox fixFirstHourCommand_7;
    @FXML private CheckBox fixFirstHourCommand_8;
    @FXML private CheckBox fixFirstHourCommand_9;
    @FXML private CheckBox fixFirstHourCommand_10;
    @FXML private CheckBox fixFirstHourCommand_11;
    @FXML private CheckBox fixFirstHourCommand_12;

    /**
     * Полное количество прошедших минут с начала аренды (после стоп таймера)
     */
    @FXML private TextField allMinuteCommand_1;
    @FXML private TextField allMinuteCommand_2;
    @FXML private TextField allMinuteCommand_3;
    @FXML private TextField allMinuteCommand_4;
    @FXML private TextField allMinuteCommand_5;
    @FXML private TextField allMinuteCommand_6;
    @FXML private TextField allMinuteCommand_7;
    @FXML private TextField allMinuteCommand_8;
    @FXML private TextField allMinuteCommand_9;
    @FXML private TextField allMinuteCommand_10;
    @FXML private TextField allMinuteCommand_11;
    @FXML private TextField allMinuteCommand_12;

    /**
     * Итоговая стоимость аренды игры
     */
    @FXML private TextField totalCostCommand_1;
    @FXML private TextField totalCostCommand_2;
    @FXML private TextField totalCostCommand_3;
    @FXML private TextField totalCostCommand_4;
    @FXML private TextField totalCostCommand_5;
    @FXML private TextField totalCostCommand_6;
    @FXML private TextField totalCostCommand_7;
    @FXML private TextField totalCostCommand_8;
    @FXML private TextField totalCostCommand_9;
    @FXML private TextField totalCostCommand_10;
    @FXML private TextField totalCostCommand_11;
    @FXML private TextField totalCostCommand_12;

    /**
     * Кнопка стоп таймер
     */
    @FXML private Button stopTimerCommand_1;
    @FXML private Button stopTimerCommand_2;
    @FXML private Button stopTimerCommand_3;
    @FXML private Button stopTimerCommand_4;
    @FXML private Button stopTimerCommand_5;
    @FXML private Button stopTimerCommand_6;
    @FXML private Button stopTimerCommand_7;
    @FXML private Button stopTimerCommand_8;
    @FXML private Button stopTimerCommand_9;
    @FXML private Button stopTimerCommand_10;
    @FXML private Button stopTimerCommand_11;
    @FXML private Button stopTimerCommand_12;

    /**
     * Прошедшее время аренды игры на текущий момент. Кнопка Обновить
     */
    @FXML private Button updateTimerCommand_1;
    @FXML private Button updateTimerCommand_2;
    @FXML private Button updateTimerCommand_3;
    @FXML private Button updateTimerCommand_4;
    @FXML private Button updateTimerCommand_5;
    @FXML private Button updateTimerCommand_6;
    @FXML private Button updateTimerCommand_7;
    @FXML private Button updateTimerCommand_8;
    @FXML private Button updateTimerCommand_9;
    @FXML private Button updateTimerCommand_10;
    @FXML private Button updateTimerCommand_11;
    @FXML private Button updateTimerCommand_12;

    /**
     * Очистить все поля, связанные с данной командой
     */
    @FXML private Button clearAllFieldCommand_1;
    @FXML private Button clearAllFieldCommand_2;
    @FXML private Button clearAllFieldCommand_3;
    @FXML private Button clearAllFieldCommand_4;
    @FXML private Button clearAllFieldCommand_5;
    @FXML private Button clearAllFieldCommand_6;
    @FXML private Button clearAllFieldCommand_7;
    @FXML private Button clearAllFieldCommand_8;
    @FXML private Button clearAllFieldCommand_9;
    @FXML private Button clearAllFieldCommand_10;
    @FXML private Button clearAllFieldCommand_11;
    @FXML private Button clearAllFieldCommand_12;

    /**
     * Слушатель действий (событий) мыши, дефолтный. Предназначен для кнопки "Старт таймер"
     */
    final EventHandler<javafx.scene.input.MouseEvent> startTimerButtonEvent = new EventHandler<javafx.scene.input.MouseEvent>(){
        @Override
        public void handle(javafx.scene.input.MouseEvent event) {
            // Записываем кнопки и поля в листы
            fieldAndButtonToList();

            // Определяем связанные кнопки, соответствующие нажатой в данный момент
            int numberButton = Integer.valueOf(event.getSource().toString().substring(0, event.getSource().toString().indexOf(",")).split("_")[1]) - 1;
            TextField nameCommand = fieldNameCommand.get(numberButton);
            TextField gameCommand = fieldGameCommand.get(numberButton);
            TextField amountPeopleCommand = fieldAmountPeopleCommand.get(numberButton);
            TextField startTimeCommand = fieldStartTimeCommand.get(numberButton);
            Button startTimerCommand = buttonStartTimerCommand.get(numberButton);
            CheckBox fixFirstHourCommand = checkBoxFixFirstHourCommand.get(numberButton);
            Button clearAllFieldCommand = buttonClearAllFieldCommand.get(numberButton);

            // Проверяем, что поля ввода заполнены верно
            try {
                if (!checkTextFieldOfNullable(nameCommand, gameCommand, amountPeopleCommand)) {
                    return;
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            // Создаем объект команды
            team = new Command();

            // Выключаем кнопку Старт таймер
            startTimerCommand.setDisable(true);

            // Получаем текущее время, запоминаем его в объект команды
            try {
                team.setTimeStampStartTheGame(timer.getTimeStamp());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Показываем время начала игры в соответствующем поле
            startTimeCommand.setText(timer.getTimeStringHHMMSS(team.getTimeStampStartTheGame()));

            // Делаем поля ввода и кнопки неактивными
            nameCommand.setEditable(false);
            gameCommand.setEditable(false);
            amountPeopleCommand.setEditable(false);
            fixFirstHourCommand.setDisable(true);
            clearAllFieldCommand.setDisable(true);

            // Запоминаем в объект команды данные с введенных полей
            team.setNameCommand(nameCommand.getText());
            team.setGameCommand(gameCommand.getText());
            team.setAmountPeopleCommand(amountPeopleCommand.getText());
        }
    };

    /**
     * Метод который является активным для всех кнопок одинакового действия.
     * На каждую кнопку навешивается дефолтный слушатель событий, реагирующий на клик (видно в данном методе)
     */
    @FXML
    public void startTimerCommand() {
        startTimerCommand_1.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_2.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_3.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_4.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_5.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_6.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_7.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_8.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_9.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_10.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_11.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
        startTimerCommand_12.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, startTimerButtonEvent);
    }

//    @FXML
//    public void startTimerCommand() throws Exception {
//        if (!checkTextFieldOfNullable()) {
//            return;
//        }
//        // Создаем объект команды
//        team = new Command();
//        // Выключаем кнопку Старт таймер
//        startTimerCommand_2.setDisable(true);
//        // Получаем текущее время, запоминаем его в объект команды
//        team.setTimeStampStartTheGame(timer.getTimeStamp());
//        // Показываем время начала игры в соответствующем поле
//        startTimeCommand_2.setText(timer.getTimeStringHHMMSS(team.getTimeStampStartTheGame()));
//        // Делаем поля ввода и кнопки неактивными
//        nameCommand_2.setEditable(false);
//        gameCommand_2.setEditable(false);
//        amountPeopleCommand_2.setEditable(false);
//        fixFirstHourCommand_2.setDisable(true);
//        clearAllFieldCommand_2.setDisable(true);
//        // Запоминаем в объект команды данные с введенных полей
//        team.setNameCommand(nameCommand_2.getText());
//        team.setGameCommand(gameCommand_2.getText());
//        team.setAmountPeopleCommand(amountPeopleCommand_2.getText());
//    }

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
    private boolean checkTextFieldOfNullable(TextField nameCommand, TextField gameCommand, TextField amountPeopleCommand) throws NoSuchFieldException {
        int cnt = 0;

        if (nameCommand.getText().isEmpty()) {
            nameCommand.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            nameCommand.setStyle(STYLE_BORDER_BASE);
        }

        if (gameCommand.getText().isEmpty()) {
            gameCommand.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            gameCommand.setStyle(STYLE_BORDER_BASE);
        }

        if (amountPeopleCommand.getText().isEmpty()) {
            amountPeopleCommand.setStyle(STYLE_BORDER_RED);
            cnt++;
        } else {
            amountPeopleCommand.setStyle(STYLE_BORDER_BASE);
        }

        try {
            Long.valueOf(amountPeopleCommand.getText());
        } catch (NumberFormatException e) {
            amountPeopleCommand.setStyle(STYLE_BORDER_RED);
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

    /**
     * Записываем все используемые поля и кнопки для данного класса-контроллера в листы,
     * для более удобного их использования
     */
    public void fieldAndButtonToList() {
        fieldNameCommand = Arrays.asList(
                nameCommand_1,
                nameCommand_2,
                nameCommand_3,
                nameCommand_4,
                nameCommand_5,
                nameCommand_6,
                nameCommand_7,
                nameCommand_8,
                nameCommand_9,
                nameCommand_10,
                nameCommand_11,
                nameCommand_12);

        fieldGameCommand = Arrays.asList(
                gameCommand_1,
                gameCommand_2,
                gameCommand_3,
                gameCommand_4,
                gameCommand_5,
                gameCommand_6,
                gameCommand_7,
                gameCommand_8,
                gameCommand_9,
                gameCommand_10,
                gameCommand_11,
                gameCommand_12
        );

        fieldAmountPeopleCommand = Arrays.asList(
        amountPeopleCommand_1,
                amountPeopleCommand_2,
                amountPeopleCommand_3,
                amountPeopleCommand_4,
                amountPeopleCommand_5,
                amountPeopleCommand_6,
                amountPeopleCommand_7,
                amountPeopleCommand_8,
                amountPeopleCommand_9,
                amountPeopleCommand_10,
                amountPeopleCommand_11,
                amountPeopleCommand_12
        );

        checkBoxFixFirstHourCommand = Arrays.asList(
        fixFirstHourCommand_1,
                fixFirstHourCommand_2,
                fixFirstHourCommand_3,
                fixFirstHourCommand_4,
                fixFirstHourCommand_5,
                fixFirstHourCommand_6,
                fixFirstHourCommand_7,
                fixFirstHourCommand_8,
                fixFirstHourCommand_9,
                fixFirstHourCommand_10,
                fixFirstHourCommand_11,
                fixFirstHourCommand_12
        );

        fieldStartTimeCommand = Arrays.asList(
                startTimeCommand_1,
                startTimeCommand_2,
                startTimeCommand_3,
                startTimeCommand_4,
                startTimeCommand_5,
                startTimeCommand_6,
                startTimeCommand_7,
                startTimeCommand_8,
                startTimeCommand_9,
                startTimeCommand_10,
                startTimeCommand_11,
                startTimeCommand_12
        );

        buttonStartTimerCommand = Arrays.asList(
                startTimerCommand_1,
                startTimerCommand_2,
                startTimerCommand_3,
                startTimerCommand_4,
                startTimerCommand_5,
                startTimerCommand_6,
                startTimerCommand_7,
                startTimerCommand_8,
                startTimerCommand_9,
                startTimerCommand_10,
                startTimerCommand_11,
                startTimerCommand_12
        );

        buttonClearAllFieldCommand = Arrays.asList(
                clearAllFieldCommand_1,
                clearAllFieldCommand_2,
                clearAllFieldCommand_3,
                clearAllFieldCommand_4,
                clearAllFieldCommand_5,
                clearAllFieldCommand_6,
                clearAllFieldCommand_7,
                clearAllFieldCommand_8,
                clearAllFieldCommand_9,
                clearAllFieldCommand_10,
                clearAllFieldCommand_11,
                clearAllFieldCommand_12
        );

        buttonUpdateTimerCommand = Arrays.asList(
        updateTimerCommand_1,
                updateTimerCommand_2,
                updateTimerCommand_3,
                updateTimerCommand_4,
                updateTimerCommand_5,
                updateTimerCommand_6,
                updateTimerCommand_7,
                updateTimerCommand_8,
                updateTimerCommand_9,
                updateTimerCommand_10,
                updateTimerCommand_11,
                updateTimerCommand_12
        );

        buttonStopTimerCommand = Arrays.asList(
                stopTimerCommand_1,
                stopTimerCommand_2,
                stopTimerCommand_3,
                stopTimerCommand_4,
                stopTimerCommand_5,
                stopTimerCommand_6,
                stopTimerCommand_7,
                stopTimerCommand_8,
                stopTimerCommand_9,
                stopTimerCommand_10,
                stopTimerCommand_11,
                stopTimerCommand_12
        );

        fieldCurrentTimeCommand = Arrays.asList(
                currentTimeCommand_1,
                currentTimeCommand_2,
                currentTimeCommand_3,
                currentTimeCommand_4,
                currentTimeCommand_5,
                currentTimeCommand_6,
                currentTimeCommand_7,
                currentTimeCommand_8,
                currentTimeCommand_9,
                currentTimeCommand_10,
                currentTimeCommand_11,
                currentTimeCommand_12
        );

        fieldAllMinuteCommand = Arrays.asList(
                allMinuteCommand_1,
                allMinuteCommand_2,
                allMinuteCommand_3,
                allMinuteCommand_4,
                allMinuteCommand_5,
                allMinuteCommand_6,
                allMinuteCommand_7,
                allMinuteCommand_8,
                allMinuteCommand_9,
                allMinuteCommand_10,
                allMinuteCommand_11,
                allMinuteCommand_12
        );

        fieldTotalCostCommand = Arrays.asList(
                totalCostCommand_1,
                totalCostCommand_2,
                totalCostCommand_3,
                totalCostCommand_4,
                totalCostCommand_5,
                totalCostCommand_6,
                totalCostCommand_7,
                totalCostCommand_8,
                totalCostCommand_9,
                totalCostCommand_10,
                totalCostCommand_11,
                totalCostCommand_12
        );
    }
}