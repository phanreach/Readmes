@FunctionalInterface
interface GameLogic {
    void play();
}

public abstract class GuestPlayer {
    protected String name;
    

    public GuestPlayer(String name) {
        this.name = name;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void rule() {
        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word by guessing one letter at a time.");
        System.out.println("You have 6 chances to guess the word correctly.");
        System.out.println("Let's start the game!");
    }
    public void performGame(GameLogic gameLogic) {
        gameLogic.play();
    }

    // Abstract method to be implemented by subclasses
    public abstract void playGame();
}
