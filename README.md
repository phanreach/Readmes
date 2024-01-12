# HangMan Game 
## Introduction
Hangman is a classic guessing game that challenges players to decipher a hidden word by guessing individual letters within a limited number of attempts.
The game typically consists of a gallows, a dash representing the letters of the word, and a stick figure that gradually takes shape as incorrect guesses are made. 
## How does it process?
Players have two choices to play as a registered player or a guest player.
If the player chooses to play as a registered player, their name will be saved in a file, but guest players will not.
The word is represented by a dash, with each space corresponding to a letter in the word. 
The player must make letter guesses one at a time, aiming to uncover the hidden word.
Each incorrect guess, a body part of the hangman is drawn on the gallows.
Each player have only 6 attempts to guess it wrong , if the limit of wrong guessing is reach , player lose the game.
## Feature 
1. Word selection an randomization: Once the player selects their player type, a random word will be retrieved from a list of words from an external text file (dictionary.txt) and displayed with dashes representing the number of characters to be guessed.
2. User Authentication: If player choose to plas as registered player, they are prompted to enter email , username and password, and the authentication class authenticate them by reading them from the data.txt file.
3. Guessing: The player begins guessing one character at a time. If the guess is correct, the dash will be replaced by a letter, and the player continues guessing the remaining letter, or they can guess all letters at the same time. If the player guesses all right, it will display the message "You win!" but if they lose or reach the limit of six attempts, it will show the full hangman body and the correct word.
## Implementation  
### Class & Object 
We have a total of 6 class
- Authentication : Use for Login
- User : It has a constructor to initialize these fields, getter methods to access them, and an overridden toString method that generates a string representation mentioning the username and password.
- Register : Register new player
- GuestPlayer : is a super class where it execute the game rule 
- RegisterPlayer : is a sub class where it take the inheritance from super class and it represent a registered player in a game with additional functionality compared to a guest player.
- Test : is a main class where it execute the logic of the game
### Inheritance
The inheritance relationship between 'GuestPlayer' class and the 'RegisterPlayer' class is :
- GuestPlayer is a super class : It serves as the base class with an instance variable 'name', provides a constructor to initialize it, has a getter and setter method for name, and also defines a rule() method to display the rules of the game. Also include a method performGame(GameLogic gameLogic) that takes a 'GameLogic' object and invokes its 'play()' method, and also declare playGame() to implement in a subclass.
- RegisterPlayer is a sub class: is a specific type of 'GuestPlayer ' with additional behavior and it inherits attributes 'name' , method and super constructor .
### Polymorphism
#### Casting 
We use casting in the main class which is Test 
```
if (player instanceof RegisterPlayer) {
        RegisterPlayer registerPlayer = (RegisterPlayer) player;
        System.out.println("Registered player name: " + registerPlayer.getName());
        }
```
We use the instanceof operator to check if the player object is an instance of the RegisterPlayer class. If it is, a cast is performed to convert the player object to a RegisterPlayer object.
### Encapsulation 
- public: Can be accessed from any other class or package. We use public on methods so that it can be use in other classes. We use public for any method that doesn't have any restriction and can be called from anywhere without causing any problems.
```
public String getName() {
        return name;
    }
```
- private: Can only be accessible within the same class and not visible to subclasses or other classes. We use private on every field to ensure their the value can only be changed inside that class and cannot be modified by any external classes. We use private on these fields because these fields are the properties of the class, so we only want their value to be modified from within the class and not allowed any external inteference.
```
private String username ;
private String password ;
private String email ;
```
- We use private on a method as well in Register class:
```
private static void saveUserToDatabase(User user) {
}
```
- protected : Can be accessible within its own package and by subclasses, whether they are in the same package or not. We use 'protected' in GuestPlayer class
```
protected String name;
```
### Abstraction 
We have 1 abstract class that use in GuestPlayer class 
```
public abstract class GuestPlayer {
}
```
and 1 abstract method 
```
 public abstract void playGame();
```
We create the abstract method to ensure the implementation of that method in the subclass.
### Exception Handling
Exception handling is incorporated to gracefully manage unexpected errors. This ensures the system can recover or gracefully terminate, we implement this to ensure the file is not found issue and the mistype input issue by using 'try' and 'catch'

file is not found: We use catch IOException to check whether the file that we need to open and write in exists or not.
```
try (PrintWriter writer = new PrintWriter(new FileWriter("C://Users//Phan Reach//Downloads//Telegram Desktop//Hangman//Data.txt", true))) {
            writer.println(user.getEmail() + "/" + user.getUsername() + "/" + user.getPassword() );
            System.out.println("User registered successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while registering the user.");
            e.printStackTrace();
        }
```
File not found: We use catch FileNotFoundException to check whether the file we need to open and read from exists or not.
```
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
```
### File I/O
- We have 2 files: 
    1. Data.txt: stored user/player data such as: email, username, password
    2. dictionary.txt: store 100 random words for player to guess
### Lambda Expression
```
public void playGame() {
        performGame(() -> {
            System.out.println("Playing the game as a registered user...");
            
        });
    }
```
A lambda expression is used to provide the implementation of the GameLogic interface's play method .
### Static method
In the project, we implement a few static methods to call out the function in another class and also call in within class.
```
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
```
