import java.util.Scanner;
/**
 * A human Tic-tac-toe player that reads moves from the keyboard.
 *
 * @author Ayo Opuiyo
 * @version 10/18/19
 */
public class HumanPlayer extends APlayer
{
    

    /**
     * Constructor for objects of class HumanPlayer
     * 
     * @param game - the tic-tac-toe game that is to be played
     * @param symbol - the character symbol to be used to represent this player's moves
     */
    public HumanPlayer(Game game, char symbol)
    {
        // initialise instance variables
        this.game = game;
        this.symbol = symbol;
    }

    /**
     * This method asks the user to pick a tic-tac-toe move. 
     * Moves are read from the keyboard and are specified by two characters rc, where r is a letter representing the row and c is a digit representing the column. 
     * For instance a1 means the 1st column of the first row and c2 means the 2nd column of the 3rd row. 
     * If the user specifies: a position that is outside the bound of the game board or, a position that is already occupied, an appropriate error message is shown and the user is asked for another position. 
     * If the user writes quit (regardless of case), the method returns null, signifying that the program should terminate.
     *
     * @param  
     * @return    the move the user chose or null if the user wants to exit
     */
    public Move pickMove(){
        Scanner scanner = new Scanner(System.in);
        String s;
        int r;
        int c;
        Move m = new Move(-1,-1);
        char val = ' ';

        while(val != 'V'){
            System.out.println("Your move! (write quit to exit).");
            s = scanner.next();
            s = s.toUpperCase();
            if (s.equals("QUIT"))
                return null;
            
            if (s.length() != 2){
                
                System.out.println("Move must have two characters.");
                continue;
            }
            c = s.charAt(0) - 'A';
            r = s.charAt(1) - '1';
            m = new Move (c, r);
            val = game.isValidMove(m);

            if (val != 'V'){
                System.out.println("Invalid Move! Please Try Again!.");
            }
            
        }
   
        return m;
    }

}