import java.util.concurrent.TimeUnit;

public class GameBoard {

    public char[][] board;

    public GameBoard(char[][] board) {
        this.board = board;
    }

    //create board
    public void newBoard() {
        board = new char[6][7];
    }

    //getter
    public char[][] getBoard() {
        return board;
    }

    //print game board
    public void displayBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'r') {
                    System.out.print("| r ");
                } else if (board[row][col] == 'y') {
                    System.out.print("| y ");
                } else {
                    System.out.print("|   ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");
        System.out.println("  1   2   3   4   5   6   7");
        System.out.println();

    }

    //returns height = no. of rows = 6 in this case
    public int getHeight() {
        return board.length;
    }

    //returns width of board = no. of columns = 7 in this case
    public int getWidth() {
        return board[0].length;
    }


    //Get counter in slot of board
    public char getCounter(int row, int column) {
        return board[row][column];
    }


    public void setCounter(char counter, int playerMove) {

            boolean placed = false;
            if (counter == 'r') {
                for (int i = board.length - 1; i >= 0; i--) {
                    if (!placed) {
                        if (board[i][playerMove - 1] == 'y') {
                            // skip
                        } else if (board[i][playerMove - 1] != 'r') {
                            board[i][playerMove - 1] = 'r';
                            placed = true;
                        }
                    }
                }
            } else if (counter == 'y') {
                for (int i = board.length - 1; i >= 0; i--) {
                    if (!placed) {
                        if (board[i][playerMove - 1] == 'r') {
                            // skip
                        } else if (board[i][playerMove - 1] != 'y') {
                            board[i][playerMove - 1] = 'y';
                            placed = true;
                        }
                    }
                }
            } else {
                //Additional Players with different counters can be implemented here
            }

        }


    public boolean winCheck(char counter){

        //horizontal
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth() - 3; j++) {
                if (getCounter(i, j) == counter) {
                    if (getCounter(i, j + 1) == counter &&
                            getCounter(i, j + 2) == counter &&
                            getCounter(i, j + 3) == counter) {
                        return true;
                    }
                }
            }
        }


        //vertical
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight() - 3; j++) {
                if (getCounter(j, i) == counter) {
                    if (getCounter(j + 1, i) == counter &&
                            getCounter(j + 2, i) == counter &&
                            getCounter(j + 3, i) == counter) {
                        return true;
                    }
                }
            }
        }

        //upward diagonal
        for (int row = 0; row < getHeight() - 3; row++) {
            for (int column = 3; column < getWidth() - 3; column++) {
                if (getCounter(row, column) == counter) {
                    if (getCounter(row + 1, column - 1) == counter &&
                            getCounter(row + 2, column - 2) == counter &&
                            getCounter(row + 3, column - 3) == counter) {
                        return true;
                    }
                }
            }
        }


        //downward diagonal
        for (int row = 0; row < getHeight() - 3; row++) {
            for (int column = 0; column < getWidth() - 3; column++) {
                if (getCounter(row, column) == counter) {
                    if (getCounter(row + 1, column + 1) == counter &&
                            getCounter(row + 2, column + 2) == counter &&
                            getCounter(row + 3, column + 3) == counter) {
                        return true;
                    }
                }
            }
        }


        return false;

    }

    //check if column is not full - playerMove = column
    public boolean validMove(int playerMove) {
            if (board[0][playerMove-1] != 'r' && board[0][playerMove-1] != 'y') {
                return true;
            }
            else {
                return false;
            }
        }

    public static void getRules() {
        System.out.println("Welcome to Connect 4");
        System.out.println("There are 2 players red and yellow");
        System.out.println("You are Player 1 and Red, Player 2 is the Computer and is Yellow");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("Whoever lost the last round gets to go first in the next game.");

        System.out.println("");
    }
    }
