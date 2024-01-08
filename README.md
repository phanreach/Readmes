# HangMan Game 
## Introduction
Hangman is a classic guessing game that challenges players to decipher a hidden word by guessing individual letters within a limited number of attempts.
The game typically consists of a gallows, a dash representing the letters of the word, and a stick figure that gradually takes shape as incorrect guesses are made. 
## Object-Oriented Features 
### Class & Object 
- Authentication : Login and Register
- User : 
- Register : 
- GuestPlayer : 
- RegisterPlayer :
- Test : 
# How does it process?
Players have two choices to play as a registered player or a guest player.
If the player chooses to play as a registered player, their score and name will be saved in a file, but guest players will not.
The word is represented by a dash, with each space corresponding to a letter in the word. 
The player must make letter guesses one at a time, aiming to uncover the hidden word.
Each incorrect guess, a body part of the hangman is drawn on the gallows.
Each player have only 6 attempts to guess it wrong , if the limit of wrong guessing is reach , player lose the game.
# Function 
1. Word selection an randomization: Once the player selects their player type, a random word will be retrieved from a list of words from an external text file (hangmanword.ext) and displayed with dashes representing the number of characters to be guessed.
2. User Authentication: If player choose to plas as registered player, they are prompted to enter email , username and password, and the authentication class authenticate them by reading them from the data.txt file.
3. Guessing: The player begins guessing one character at a time. If the guess is correct, the dash will be replaced by a letter, and the player continues guessing the remaining letter, or they can guess all letters at the same time. If the player guesses all right, it will display the score and message "You win!" but if they lose or reach the limit of six attempts, it will show the full hangman body.
# Code Explaination
. We have 7 separate classes, which are GuestPlayer (Super Class), RegisterPlayer (Sub Class), Test (Main Class), Register, User, Login, Authentication, and 1 txt file called data.txt
1. GuestPlayer(Super Class) : 
    1. @Functionalinterface:  This is an annotation used to indicate that the GameLogic interface is functional interface. A functional interface is an interface that has only one abstract methdo and can be used as the basis for lambda expressions or method references.
    2. public abstract class GuestPlayer: This is an abstract class that serves as base class for guest players in the game , it provide common functionality and properties that guest player require.
    3. In the code also have one variable called name(String) as protected to protected other class access into the code
    4. Constructor: initialize the name properties of the guest player object.
    5. Getter and setter method:
        1. getName() are getter method to return the name of the guest player.
        2. setName(String name) are setter method to set the name of the guest player
        3. These methods provide access to the private properties of the guest player object. 
    7. void rule() : Display the rule of the game .
    8. void performGame(GameLogic gameLogic) : This method takes an object implementing the GameLogic interface and calls its play() method. it allow the guest player to perform a game using a specific game logic.
    9. abstract void playGame() : This is an abstract method that must be implemented by subclasses of GuestPlayer .
2. RegisterPlayer(Sub Class) :
    1. public class RegisterPlayer extends GuesPlayer : declare the RegisterPlayer class as a subclass of GuestPlayer.
    2. public RegisterPlayer(String name): This is the constructor of the RegisterPlayer class. It calls the constructor of the superclass (GuestPlayer) using the super(name) statement.
    3. @Override annotation : indicates that the following method is meant to override a method inherited from the superclass.
    4. public void rule() :
        1. This is the overridden rule() method of the RegisterPlayer class. It overrides the rule() method defined in the GuestPlayer class.
        2. The super.rule() statement calls the rule() method of the superclass (GuestPlayer) to print the initial rules and instructions of the Hangman game.
    5. public void performGame(GameLogic gameLogic) : is the method from super class . It take the gameLogic as a parameter and called play method . 
    6. public void playGame():
        1. This is the overridden playGame() method from the super class and it call performGame with lambda expression .
        2. The additional line System.out.println("Playing the game as a registered user..."); prints a message indicating that the game is being played by a registered user.
    7. Overriding method : it's return a string representation of RegisterPlayer including name of the player. 
3. Register:
    1. The code import necessary classes: FileWriter, IOExeption, PrintWriter, and Scanner.
    2. main method serve as the entry point of the program.
    3. Scanner object is created to read user input
    4. Program prompt user to enter email, username, password and read the input using the scanner.nextLine()
    5. The void registerUser method is called, passing the entered username, password, and email as arguments.
    6. The registerUser method creates a new User object with the provided information.
    7. The saveUserToDatabase method is called, passing the User object as an argument.
    8. The saveUserToDatabase method attempts to write the user information to the "Data.txt" file using a PrintWriter wrapped around a FileWriter.
    9. If the writing process is successful, the user is informed that the registration was successful. Otherwise, an error message is displayed Error occured while registering the user.
4. User:
    1. Have three private instance variable : username, password and email . 
    2. Overloading method have 3 constructor :
        1. The first constructor take only username as a parameter.It initialize the username field with the provide value and set both password and email to null.
        2. The second constructor take the username and password as parameter.  It initializes the username and password fields with the provided values and sets the email field to null.
        3. The third constructor akes all three parameters: username, password, and email. It initializes all three fields with the provided values.
    3. The class provides getter methods for the username, password, and email fields, allowing access to these private variables from outside the class.
    4. The toString method is overridden to provide a string representation of the User object. It returns a formatted string that includes the username and password.
5. Authentication:
    1. import the important file such as File , FileNotFoundException , Scanner. 
    1. The boolean authenticateUser method take 3 parameter: username , password and email.
    2. The method attempts to read the user data from a file named "Data.txt"
    3. Inside while loop, the method process each line of the file. Each line is split using the "/" delimiter into an array of parts using the split() method.
    4. If the conditions in step 4 are satisfied, the stored email, username, and password are extracted from the parts array.
    5. The method then compares the stored email, username, and password with the user-provided email, username, and password using the equals() method. If all three match, it means the user credentials are valid, and the method returns true.
    6. If the end of the file is reached without finding a match, or if the file is not found (FileNotFoundException is caught), the method returns false.
    7. Finally, if an exception occurs while attempting to read the file, an error message is printed to the console using System.err.println(), and the stack trace is printed using e.printStackTrace().
6. Test(Main Class):
    1. The code starts by import necessary class
    2. main method serve as a entry point
    3. Inside main method, it initializes several Scanner objects to read user input and a List to store word for the game and it read word from file ("dictionary.txt") and adds them to the "words" list.
    4. The program prompt user to choose an option: playing as a registed or guest or register new player .
    5. If user choose to play as register , they are prompted to enter their email, username and password. The "Authentication.authenticateUser" method is called to verify the user's credentials. If the login is successful, a "RegisterPlayer" object is created. Otherwise, an "Invalid username or password" message is displayed, and a "GuestPlayer" object is created.
    6. If the user choose to play as a guest, they are prompted to enter their name and start to play
    7. if the user choose to register new player , user are prompt to register their email , name and password . The authentication will verify the account is already existing or not, if not the user is create . And it prompt user again to input their email , username and password that they create . 
    8. the rule method is called to display
    9. Casting : it check the condition if player is a instance of RegisterPlayer , The player will turn into RegisterPlayer type in order to access to the properties of the RegisterPlayer class and print the register player name . And also display "Start Guessing"
    10. The program generate a random word from the "words" list
    11. Create playerGuesses to store the character user guess and also define wrongCount as integer and set to 0 
    12. A while loop is used to iterate until the game is over. Inside the loop, the hangman image is printed based on the number of wrong guess
    13. If player reach limit guess , the player loses and the correct word is displayed
    14. Program prompts player to enter their guess , if the guess matches the word, the player wins. otherwise , the program check if the guess contains any correct letters. If yes, those letter are added to the "playerGuesses" list. if no, "wrongCount" is incremented.
    15. After each guess, the "playGame" method of the player object is called
    16. Once the game is over, the program is closed, and the Scanners are closed.
    17. The code also includes two helper methods: "printHangedMan" to display the hanged man's image and "printWordState" to print the current state of the guessed word. 
