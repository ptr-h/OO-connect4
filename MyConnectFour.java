import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
//variable pass as parameter otherwise only local to method
//add way to choose first player


public class MyConnectFour {

    private final GameSequence gameseq;
    GameBoard board;
    List<Player> players;

    public MyConnectFour(GameBoard board, List<Player> players, GameSequence gameseq) {
        this.board = board;
        this.players = players;
        this.gameseq = gameseq;
    }


    public void startGame() {

        board.getRules();
        board.newBoard();
        board.displayBoard();
        gameseq.run();
    }


}