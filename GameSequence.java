import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class GameSequence {


    private final GameBoard board;
    private final List<Player> players;
    boolean continuePlay = true;
    int totalTurns = 0;
    int currentPlayer = 0;
    int playerMove;
    int compMove;

    public GameSequence (GameBoard board, List<Player> players) {
        this.board = board;
        this.players = players;
    }

    //check if the user wants to play another round
    //loser starts next round
    public boolean playAgain() {
        System.out.println("Would you like to play again?");
        System.out.print("Enter Y or N: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String playAgain;
        while (true) {
            try {
                playAgain = input.readLine();
                if (!(playAgain.equals("Y") | playAgain.equals("N"))) {
                    System.out.println("This is not a valid answer.");
                    System.out.println("Enter Y to play again, or N to end the game: ");
                }
                if (playAgain.equals("Y")) {
                    totalTurns = 0;
                    board.newBoard();
                    if (currentPlayer==1) {
                        board.displayBoard();
                    }
                    return true;

                }
                if (playAgain.equals("N")) {
                    continuePlay = false;
                    return false;
                }
            } catch (Exception e) {
                System.out.println("This is not a valid answer, please try again.");

            }
        }

    }



    public void run()
    {while (continuePlay) {


        //check if game is a draw/tie
        if (totalTurns >= 42) {
            System.out.println("It's a tie. The Board is full.");
            if (!playAgain()) {
            break;}
        }

        //------------User Player--------------------------//

        //valid move check
        while (true) {

            System.out.print("Your move: ");
            playerMove = players.get(currentPlayer).getMove();

            if (board.validMove(playerMove)) {
                break;
            } else {
                System.out.println("The column is full, try a different move.");
            }
        }


        //place counter and update variables
        board.setCounter(players.get(currentPlayer).getCounter(), playerMove);
        totalTurns += 1;
        currentPlayer = 1;
        //board.displayBoard();


        //win check
        if (board.winCheck('r')) {
            board.displayBoard();
            System.out.println("You Win, Humans beat computers.");
            if (!playAgain()) {
                break;}
        }


       //------Computer Player------------//

        //valid move check
        while (true) {
            compMove = players.get(currentPlayer).getMove();
            if (board.validMove(compMove)) {
                break;
            }
        }

        //adds computer pausing to "think"
        //players.get(currentPlayer).delayPlay();

        //place counter and update variables
        board.setCounter(players.get(currentPlayer).getCounter(), compMove);
        totalTurns += 1;
        board.displayBoard();


        //win check
        if (board.winCheck('y')) {
            System.out.println("I Win, Computers beat humans.");
            if (!playAgain()) {
                break;}
        }

        currentPlayer = 0;


}}}