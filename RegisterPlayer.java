public class RegisterPlayer extends GuestPlayer {

    public RegisterPlayer(String name) {
        super(name);
    }


    @Override
    public void rule() {
        super.rule();  // Call the superclass rule method if needed
    }

    

    @Override
    public void performGame(GameLogic gameLogic) {
        gameLogic.play();
    }

    @Override
    public void playGame() {
        performGame(() -> {
            System.out.println("Playing the game as a registered user...");
            
        });
    }

    @Override
    public String toString() {
        return "RegisterPlayer{" +
                "name='" + name +
                '}';
    }
}