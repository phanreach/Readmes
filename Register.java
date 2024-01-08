import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Register {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create your email: ");
        String email = scanner.nextLine();

        System.out.println("Create user name: ");
        String username = scanner.nextLine();

        System.out.println("Create password: ");
        String password = scanner.nextLine();
    

        registerUser(username , password , email );

        scanner.close();
    }

    public static void registerUser(String username, String password, String email) {
        User user = new User(username, password, email );
        saveUserToDatabase(user);
    }

    private static void saveUserToDatabase(User user) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C://Users//Phan Reach//Downloads//Telegram Desktop//Hangman//Data.txt", true))) {
            writer.println(user.getEmail() + "/" + user.getUsername() + "/" + user.getPassword() );
            System.out.println("User registered successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while registering the user.");
            e.printStackTrace();
        }
    }
}