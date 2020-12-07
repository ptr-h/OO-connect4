public abstract class Player {

    private final char counter;

    public Player(char counter) {
        this.counter = counter;
    }

    abstract int getMove();

    public char getCounter(){
        return counter;
    }

    public void delayPlay(){
        try {
            System.out.println("I am thinking...");
            Thread.sleep(3000);
        } catch
        (InterruptedException e) {}}}



