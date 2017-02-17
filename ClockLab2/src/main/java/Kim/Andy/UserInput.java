package Kim.Andy;

import java.util.Scanner;

/**
 * Created by andykim on 2/16/17.
 */
public class UserInput {
    public void promptUser(){
        System.out.println("Enter time");
    }
    public String getUserInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
