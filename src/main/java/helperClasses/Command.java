package helperClasses;

/**
 * @author p.sharikov
 **/
public class Command {

    private String nameCommand;
    private String gameCommand;
    private String amountPeopleCommand;
    private Long timeStampStartTheGame;
    private Long timeStampEndTheGame;
    private boolean fixFirsHourGame;

    /**
     * Узнать фиксированн ли первый час игры
     *
     * @return
     */
    public boolean isFixFirsHourGame() {
        return fixFirsHourGame;
    }

    /**
     * Установить фиксированный первый час игры
     *
     * @param fixFirsHourGame
     */
    public void setFixFirsHourGame(boolean fixFirsHourGame) {
        this.fixFirsHourGame = fixFirsHourGame;
    }

    /**
     * Получить название команы, имя человека
     *
     * @return
     */
    public String getNameCommand() {
        return nameCommand;
    }

    /**
     * Установить название команы, имя человека
     *
     * @param nameCommand
     */
    public void setNameCommand(String nameCommand) {
        this.nameCommand = nameCommand;
    }

    /**
     * Получить название игры в которую играет команда
     *
     * @return
     */
    public String getGameCommand() {
        return gameCommand;
    }

    /**
     * Установить название игры в которую играет команда
     *
     * @param gameCommand
     */
    public void setGameCommand(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    /**
     * Получить количество человек в команде
     *
     * @return
     */
    public String getAmountPeopleCommand() {
        return amountPeopleCommand;
    }

    /**
     * Установить количество человек в команде
     *
     * @param amountPeopleCommand
     */
    public void setAmountPeopleCommand(String amountPeopleCommand) {
        this.amountPeopleCommand = amountPeopleCommand;
    }

    /**
     * Получить время начала игры
     *
     * @return
     */
    public Long getTimeStampStartTheGame() {
        return timeStampStartTheGame;
    }

    /**
     * Установить время начала игры
     *
     * @param timeStampStartTheGame
     */
    public void setTimeStampStartTheGame(Long timeStampStartTheGame) {
        this.timeStampStartTheGame = timeStampStartTheGame;
    }

    /**
     * Получить время окончания игры
     *
     * @return
     */
    public Long getTimeStampEndTheGame() {
        return timeStampEndTheGame;
    }

    /**
     * Установить время окончания игры
     *
     * @param timeStampEndTheGame
     */
    public void setTimeStampEndTheGame(Long timeStampEndTheGame) {
        this.timeStampEndTheGame = timeStampEndTheGame;
    }
}