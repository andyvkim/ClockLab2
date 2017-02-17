package Kim.Andy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andykim on 2/16/17.
 */
public class ClockConverterToWords {
    String[] timeOptions = {
            "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    String[] tensTimeOptions = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };


    public boolean isMilitaryTime(String time){
        time = time.toLowerCase();
        if (!time.contains("pm") && !time.contains("am")){
            return true;
        }
        return false;
    }
    public String getMeridien(String time){
        time = time.toLowerCase();
        Pattern pattern = Pattern.compile("(am|pm)");
        Matcher matcher = pattern.matcher(time);
        String meridien ="";
        if(matcher.find()){
            meridien = matcher.group();

        }
        return meridien;
    }
    public String removeMeridiens(String time){
        time = time.toLowerCase();
        return time.replaceAll("am|pm","");
    }
    public String[] splitByColon(String time){
        return time.split(":");
    }
    public String convertTimeToString(String[] timeArray){
        StringBuilder sb = new StringBuilder();
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        if (hours < 20){
            sb.append(timeOptions[hours] + " ");
        }
        else if (hours >= 20 && hours <= 24){
            sb.append("twenty-");
            sb.append(timeOptions[hours%20]);
        }
        if (minutes < 20){
            sb.append(timeOptions[minutes] + " ");
        }
        else if (minutes >= 20 && minutes <= 59){
            sb.append(tensTimeOptions[minutes/10]);
        }
        return sb.toString();
    }


}
