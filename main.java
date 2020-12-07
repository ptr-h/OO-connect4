import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

        //create game board
        char[][] newBoard = new char[6][7];
        GameBoard board = new GameBoard(newBoard);

        //create list of players - useful to extend code to multiple players
        ArrayList<Player> players  = new ArrayList<>();
        HumanPlayer user = new HumanPlayer('r');
        ComputerPlayer computerUser = new ComputerPlayer('y');
        players.add(user);
        players.add(computerUser);

        //create game sequence
        new GameSequence(board, players);
        GameSequence gameseq = new GameSequence(board, players);

        //create new game instance of connect four
        MyConnectFour newgame = new MyConnectFour(board, players, gameseq);
        newgame.startGame();

    }
}