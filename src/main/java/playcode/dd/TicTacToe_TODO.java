package playcode.dd;

public class TicTacToe_TODO {

    /** Initialize your data structure here. */
    private int[][][] state;

    /**
     * d1 row
     * d2 col
     * d3: X 1; O2
     */
    public TicTacToe_TODO() {
        state = new int[3][3][1];
    }

    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
        
        return true;
    }

    public static class AlreadyTakenException extends RuntimeException{
        public AlreadyTakenException(String msg){
            super(msg);
        }
    }

    public static class GameEndException extends RuntimeException{
        public GameEndException(String msg){
            super(msg);
        }

    }
}
