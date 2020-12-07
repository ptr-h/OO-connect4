import java.io.BufferedReader;
import java.io.InputStreamReader;


public class HumanPlayer extends Player {

    public HumanPlayer (char counter){
        super(counter);
    }

    public int getMove() {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int move = 0;

        String toReturn = null;
        while (true){
            try {
                toReturn = input.readLine();
                move = Integer.parseInt(toReturn);
                if (move < 1 | move > 7) {
                    throw new IllegalArgumentException("Num outside range");
                }
                else{
                    return move;
                }
            } catch (Exception e) {
                System.out.println("This is not a valid play, please try again.");
                System.out.print("Enter a valid move: ");
            }
        }
    }



}
