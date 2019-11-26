/**
 * A computer-controlled Tic-tac-toe player that implements a random playing strategy.
 *
 * @author Ayo Opuiyo
 * @version 10/18/19
 */
class CpuPlayer extends APlayer{
    /**
     * Constructor for objects of class CPUTicPlayer
     */
    public CpuPlayer(Game game, char symbol){
        this.game = game;
        this.symbol = symbol;
    }
    
    /**
     * Picks a move uniformly at random. It does this by generating random moves within the game board boundaries until it finds an unnocupied position. 
     * Assumes the game isn't over yet, otherwise it'd go into an infinite loop.
     * 
     * @return the chosen move. Because the CPU never quits, this implementation method never returns null.
     */
    public Move pickMove(){
        int c;
        int r;
        char chr;
        Move m = new Move(-1,-1);
        char val = ' ';
        while (val != 'V') { 
            c = ((int) (Math.random() * game.boardsize));
            chr = (char) (c + 'A');
            r = ((int) (Math.random() * game.boardsize));
            m = new Move(c, r);
            val = game.isValidMove(m);
            
            if (val == 'V'){
                System.out.println(" ");
                System.out.println("CPU's Move: ("+ chr + "," + (r+1) +")");
            }
        }
        return m;
    }
}