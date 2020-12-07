import java.util.concurrent.ThreadLocalRandom;


public class ComputerPlayer extends Player {

    public ComputerPlayer(char counter) {
        super(counter);
    }

    public int getMove() {
        return ThreadLocalRandom.current().nextInt(1, 8);
    }

}


// TO MAKE THE COMPUTER INTELLIGENT
// Algo should follow by order of priority
// -- Place counter in winning position if any present
// -- Block player's winning moves if any present
// -- Prioritise center squares, then corners, then edges
