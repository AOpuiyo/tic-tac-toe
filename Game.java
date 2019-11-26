/**
 * Represents a Tic-tac-toe game.
 *
 * @author Ayo Opuiyo
 * @version 10/18/19
 */
public class Game{
    /**represents the game board as matrix of player symbols*/
    char [][] board;

    /**represents board size, which will be a boardSize x boardSize matrix*/
    final int boardsize;

    /**represents the game board as matrix of player symbols*/
    APlayer [] players;

    /**the character to be used to represent a blank space on the board (' ')*/
    char SYMBOL_BLANK =' ';

    /**the character to be used to represent a cpu move on the board ('O')*/
    char SYMBOL_CPU = 'O';

    /**the character to be used to represent a human move on the board ('X')*/
    char SYMBOL_HUMAN = 'X';

    /**
     * Constructor for objects of class TicGame.
     * @param  boardSize - the game board size, which will be a boardSize x boardSize matrix
     * 
     */
    Game (int boardsize){
        this.boardsize = boardsize;
        this.board = new char [boardsize][boardsize];
        this.players = new APlayer [2];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = SYMBOL_BLANK;
            } 
        }
    }

    /**
     * Creates a textual representation of the game board in the format:
    1   2   3 
    A  X | O | O  
    ---|---|--- 
    B    | X |   
    ---|---|---
    C  O |   | X 

     *@param  
     * @return A String representing the game board in the aforementioned format.
     */
    
    public String toString(){
        String str = " ";
        for (int i = 0; i < board.length; i++){
            int count = 1 + i;
            str = str + " " + count + "  ";
        }
        for (int i = 0; i < board.length; i++){ 
            char ltr = (char)(65 + i);
            str = str + "\n" + ltr + "";

            for (int j = 0; j <= board[i].length - 1; j++){

                if (j == (board.length - 1)){
                    str = str + " " + board[i][j] + "\n";
                } else {
                    str = str + " " + board [i][j] + " " + "|" + "";
                }
            }

            for (int k = 0; k < board.length; k++){
                if (k == board.length - 1){
                    str = str + "---";
                } else if (k == 0){
                    str = str + " ---|";
                } else {
                    str = str + "---|";
                }
            }
        }
        return str;
    }

    /**
     * Validates a potential move. Returns 'V' if the move is valid, or a different character indicating the reason why the move is invalid.
     * 
     *  @param  move  the move to be validated.
     *  
     * @return 'V' is move is valid, 'R' if it specifies an invalid row, 'C' if it specifies an invalid column, or 'O' if it refers to an already-occupied position.
     */
    public char isValidMove(Move move){
        if (move.col < 0 || move.col >= board.length){
            return 'C';
        }
        else if (move.row < 0 || move.row >= board.length) {
            return 'R';
        }
        else if (board[move.col][move.row] != SYMBOL_BLANK)
            return 'O';
        else
            return 'V';
    }

    /**
     * Executes the move passed as an argument. If the move is invalid it returns false.
     * 
     *  @param move  the move to be executed 
     *  @param symbol the symbol of the player who is making the move
     *  
     * @return true if the move was successfully executed
     */
    protected boolean executeMove(Move move, char symbol){
        char val = this.isValidMove(move);
        if (val == 'V'){
            board[move.col][move.row] = symbol;
            return true; 
        } else {
            return false;
        }
    }

    /**
     * A method that analyzes the board to determine the current game sate, which is then returned as a character. A game is over if either player has completed a row, a line, or a diagonal. 
     * Moreover, a game is also over if the board is full, even if no player completed a row, line, or diagonal. That indicates a tie situation.
     * 
     *  @param  
     * @return A character indicating the game state: '?' if the game isn't over yet, 'T' if the game is over and tied, or, if a player won, the winning player's symbol ('X' or 'O'). 
     */
    public char getGameStatus(){

        for (int i = 0; i < board.length; i++){
            int rowsx = 0;
            int rowsy = 0;
            for (int j = 0; j < board[i].length; j++){

                if(board[i][j] == 'X')
                    rowsx++;
                else if(board[i][j] == 'O')
                    rowsy++;

            }

            if (rowsx == boardsize)
                return 'X';
            else if (rowsy == boardsize)
                return 'O';

        }

        for (int i = 0; i < board.length; i++){
            int colsx = 0;
            int colsy = 0;
            for (int k = 0; k < board[i].length; k++){
                if(board[k][i] == 'X')
                    colsx++;
                else if(board[k][i] == 'O')
                    colsy++;
            }

            if (colsx == boardsize)
                return 'X';
            else if (colsy == boardsize)
                return 'O';
        }
        int diagx = 0;
        int diagy = 0;
        for (int i = 0; i < board.length; i++){
            if(board[i][i] == 'X')
                diagx++;
            else if(board[i][i] == 'O')
                diagy++;

            if(diagx == boardsize)
                return 'X';
            else if(diagy == boardsize)
                return 'O';
        }
        int antDiagx = 0;
        int antDiagy = 0;
        for (int i = 0, j = boardsize - 1; i < board.length; i++, j--){

            if(board[i][j] == 'X')
                antDiagx++;
            else if(board[i][j] == 'O')
                antDiagy++;

            if(antDiagx == boardsize)
                return 'X';
            else if(antDiagy == boardsize)
                return 'O';
        }

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == SYMBOL_BLANK)
                    return '?';    
            }
        }

        return 'T';
    }

    /**
     * Resets the game state so we can play again.
     *  @param  
     * @return void 
     */
    protected void resetGame(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = SYMBOL_BLANK;
            }
        }
    }

    /**
     * Plays a single game of Tic-tac-toe by having players pick moves in turn. The first player to play is choosen uniformly at random.
     *  @param  
     * @return A character representing the game's result: 'H' if the human player won, 'C' if the CPU won, 'T' if there was a tie, or 'Q' if the human quit the game. 
     */
    public char playSingleGame(){
        GameStats gs = new GameStats();
        players[0] = new HumanPlayer (this, 'X');
        players[1] = new CpuPlayer (this, 'O');
        int i = 0;

        System.out.println(this + "\n");
        char val = this.getGameStatus();
        if (Math.random() > .5)
            i = 1;
        while (val == '?'){
            Move mo = players[i].pickMove();

            if (mo != null)
                this.executeMove(mo, players[i].symbol);
            else return 'Q';

            val = this.getGameStatus();
            System.out.println(this + "\n");

            if (i == 0)
                i = 1;
            else i = 0;
        }

        if (val == 'X')
            return 'H';
        else if (val == 'O')
            return 'C';

        return val;
    }

    /**
     * Runs consecutive Tic-tac-toe games until the user gets tired and quits. When the user quits, the win-loss-tie statistics are printed.
     * 
     * @param  args  The first argument represents the desired game board size, which should be an integer in [1,9]. 
     * If the provided board size does not comply with these rules or if no argument is provided, a default game board size of 3 x 3 will be used.
     * @return void 
     */
    public static void main(String[] args) {
        Game gm;
        
        //if user inputs args set game boardsize, otherwise make 3 X 3 matrix
        if (args.length == 0)
            gm = new Game(3);
        else {
            int arg1 = Integer.parseInt(args[0]);
            gm = new Game (arg1);
        }

        GameStats gs = new GameStats();
        char val = gm.playSingleGame();
        while (val != 'Q'){
            val = gm.playSingleGame();
            if (val == 'H'){
                gs.recordWin();
                System.out.println("Congratulations you won! Play Again?\n");
                System.out.println("----------NEW GAME-------");
            }
            else if (val == 'C'){
                gs.recordLoss();
                System.out.println("Your loss! Play Again?\n");
                System.out.println("----------NEW GAME-------");
            }
            else if (val == 'T'){
                gs.recordTie();
                System.out.println("You tied! Play Again?\n");
                System.out.println("----------NEW GAME-------");
            }
            gm.resetGame();
        }

        if (val == 'Q'){
            System.out.println(gs + "\n");
            System.out.println("Goodbye and thanks for playing!");
        }
    }
}

