# HangMan Game 
Hangman is a classic guessing game that challenges players to decipher a hidden word by guessing individual letters within a limited number of attempts.
The game typically consists of a gallows, a dash representing the letters of the word, and a stick figure that gradually takes shape as incorrect guesses are made. 
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
    3. In the code also have two variable called name(String) , score(int)
    4. Constructor: initialize the name and score properties of the guest player object.
    5. Getter and setter method:
        1. getName() and getScore() are getter method to retrieve the name and score of the guest player.
        2. setName(String name) and setScore(int score) are setter method to set the name and score of the guest player
        3. These methods provide access to the private properties of the guest player object. 
    6. incrementScore(int points) : This method allows the guest player to increase their score by a specified number of points .
    7. rule() : Display the rule of the game .
    8. performGame(GameLogic gameLogic) : This method takes an object implementing the GameLogic interface and calls its play() method. it allow the guest player to perform a game using a specific game logic.
    9. abstract void playGame() : This is an abstract method that must be implemented by subclasses of GuestPlayer .
2. RegisterPlayer(Sub Class) :
    1. public class RegisterPlayer extends GuesPlayer : declare the RegisterPlayer class as a subclass of GuestPlayer.
    2. public RegisterPlayer(String name, int score): This is the constructor of the RegisterPlayer class. It calls the constructor of the superclass (GuestPlayer) using the super(name, score) statement.
    3. @Override annotation : indicates that the following method is meant to override a method inherited from the superclass.
    4. public void rule() :
        1. This is the overridden rule() method of the RegisterPlayer class. It overrides the rule() method defined in the GuestPlayer class.
        2. The super.rule() statement calls the rule() method of the superclass (GuestPlayer) to print the initial rules and instructions of the Hangman game.
        3. The additional line System.out.println("Welcome " + this.name + " to the game "); prints a welcome message with the player's name.
    5. public void playGame():
        1. This is the overridden playGame() method of the RegisterPlayer class. It overrides the playGame() method defined in the GuestPlayer class.
        2. The super.rule() statement calls the rule() method of the superclass (GuestPlayer) to print the initial rules and instructions of the Hangman game.
        3. The additional line System.out.println("Playing the game as a registered user..."); prints a message indicating that the game is being played by a registered user.
3. Register: 
4. Login:
5. User:
6. Authentication: 
7. Test(Main Class): 
