package helperClasses;

/**
 * @author p.sharikov
 **/
public class Command {

    // Название команы, имя человека
    private String nameCommand;
    // Название игры в которую играет команда
    private String nameGameForCommand;
    // Количество человек в команде
    private String amountMemberCommand;
    // Время начала игры
    private Long timeStampStartTheGame;
    // Время окончания игры
    private Long timeStampEndTheGame;
    // Фиксированный первый час игры
    private boolean fixFirsHourGame;

    public boolean isFixFirsHourGame() {
        return fixFirsHourGame;
    }

    public void setFixFirsHourGame(boolean fixFirsHourGame) {
        this.fixFirsHourGame = fixFirsHourGame;
    }

    public String getNameCommand() {
        return nameCommand;
    }

    public void setNameCommand(String nameCommand) {
        this.nameCommand = nameCommand;
    }

    public String getNameGameForCommand() {
        return nameGameForCommand;
    }

    public void setNameGameForCommand(String nameGameForCommand) {
        this.nameGameForCommand = nameGameForCommand;
    }

    public String getAmountMemberCommand() {
        return amountMemberCommand;
    }

    public void setAmountMemberCommand(String amountMemberCommand) {
        this.amountMemberCommand = amountMemberCommand;
    }

    public Long getTimeStampStartTheGame() {
        return timeStampStartTheGame;
    }

    public void setTimeStampStartTheGame(Long timeStampStartTheGame) {
        this.timeStampStartTheGame = timeStampStartTheGame;
    }

    public Long getTimeStampEndTheGame() {
        return timeStampEndTheGame;
    }

    public void setTimeStampEndTheGame(Long timeStampEndTheGame) {
        this.timeStampEndTheGame = timeStampEndTheGame;
    }
}