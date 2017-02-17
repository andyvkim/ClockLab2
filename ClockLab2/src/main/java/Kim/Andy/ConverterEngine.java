package Kim.Andy;

/**
 * Created by andykim on 2/16/17.
 */
public class ConverterEngine {
    ClockConverterToWords clockConverterToWords = new ClockConverterToWords();
    PrintTime printTime = new PrintTime();
    UserInput userInput = new UserInput();

    public void run(){
        String time = promptUser();
        String convertedTime = "";
        String meridiens = "";
        if (clockConverterToWords.isMilitaryTime(time)){
           convertedTime =  convert(time);
        }
        else {
            meridiens =  clockConverterToWords.getMeridien(time);
            String removedmMeriediensTime = clockConverterToWords.removeMeridiens(time);
            convertedTime = convert(removedmMeriediensTime);
        }
        printTime.printTimeOut(convertedTime, meridiens);
    }
    public String convert(String time){
        String[] timeArray = clockConverterToWords.splitByColon(time);
        return clockConverterToWords.convertTimeToString(timeArray);
    }
    public String promptUser(){
        userInput.promptUser();
        return userInput.getUserInput();
    }
}
