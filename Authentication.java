import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Authentication {
    public static boolean authenticateUser(String username, String password , String email) {
        try (Scanner scanner = new Scanner(new File("C://Users//Phan Reach//Downloads//Telegram Desktop//Hangman//Data.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("/");
                
                if (parts.length >= 3) {
                String storedEmail = parts[0];
                String storedUsername = parts[1];
                String storedPassword = parts[2];
                

                if (email.equals(storedEmail) && username.equals(storedUsername) && password.equals(storedPassword)) {
                    return true;
                }
            }
            
        }
        } catch (FileNotFoundException e) {
            System.err.println("Error: User database file not found.");
            e.printStackTrace();
        }

        return false;
    }
}