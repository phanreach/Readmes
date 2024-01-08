import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C://Users//Phan Reach//Downloads//Telegram Desktop//Hangman//dictionary.txt"));
        Scanner scanner = new Scanner(System.in);
        Scanner keyboard = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        
        while (sc.hasNextLine()) {
            words.add(sc.nextLine());
        }

        GuestPlayer player ; 

       
        System.out.println("Please choose an option:");
        System.out.println("1. Play as a registered user");
        System.out.println("2. Play as a guest");
        System.out.println("3. Register new player");

        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 3) {

            System.out.println("Create your email: ");
            String email = scanner.nextLine();

            System.out.println("Create user name: ");
            String username = scanner.nextLine();

            System.out.println("Create password: ");
            String password = scanner.nextLine();

            if (Authentication.authenticateUser(username, password, email)) {
                System.out.println("Player is already exist.");
                System.out.println("Try agian!!!");
                choice = 1;

            } else {

                Register.registerUser(username, password, email);
                System.out.println("Register complete!");
                choice = 1;
            }

        }


        if (choice == 1) {
            System.out.println("You chose to play as a registered user.");
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            System.out.println("Please enter your username: ");
            String username = scanner.nextLine();
        
            System.out.println("Please enter your password: ");
            String password = scanner.nextLine();
        
            if (Authentication.authenticateUser(username, password, email)) {
                System.out.println("Login successful!");
                System.out.println("Starting Hangman game...");
                player = new RegisterPlayer(username);
            } else {
                System.out.println("Invalid username or password. Login failed.");
                System.out.println("Please enter your name: ");
                String name = scanner.nextLine();
                player = new GuestPlayer(name) {
                    @Override
                    public void playGame() {
                        // Add your implementation for playing the game as a guest
                        System.out.println("Playing the game as a guest...");
                    }
                };
            }
        } else if (choice == 2) {
            System.out.println("You chose to play as a guest.");
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            
            // Instantiate an anonymous subclass for guests
            player = new GuestPlayer(name) {
                @Override
                public void playGame() {
                    // Add your implementation for playing the game as a guest
                    System.out.println("Playing the game as a guest...");
                }
            };
        } else {
            System.out.println("Invalid choice. Please try again.");
            scanner.close();
            keyboard.close();
            sc.close();
            return; // Exit the program
        }

        player.rule();

        //casting 
    
        if (player instanceof RegisterPlayer) {
        RegisterPlayer registerPlayer = (RegisterPlayer) player;
        System.out.println("Registered player name: " + registerPlayer.getName());
        }


        System.out.println("Start Guessing ");

        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));

        List<Character> playerGuesses = new ArrayList<>();
        int wrongCount = 0;

        while (true) {
            printHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
                break;
            }

            if (printWordState(word, playerGuesses)) {
                System.out.println("You win!");
        
                break;
            }

            System.out.println("Please enter your guess for the word:");
            String guess = keyboard.nextLine();
            if (guess.equals(word)) {
                System.out.println("You win!");
                
                break;
            } else if (word.contains(guess)) {
                for (char c : guess.toCharArray()) {
                    playerGuesses.add(c);
                }
            } else {
                wrongCount++;
            }
            player.playGame();
        }

        scanner.close();
        keyboard.close();
        sc.close();
    }

    private static void printHangedMan(int wrongCount) {
        System.out.println(" -------");
        System.out.println(" |     |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }


}
