/**
 * Represents a player move in a Tic-tac-game.
 *
 * @author Ayo Opuiyo
 * @version 10/18/19
 */
class Move {
    /**the move's column*/
    int col;
    /**the move's row*/
    int row;
    
    /**
     * Constructor for objects of class Move.
     * @param row  the move's row
     * @param col  the move's column
     */
    Move (int col, int row){
        this.col = col;
        this.row = row;
        
    }

}