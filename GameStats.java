
/**
 * A container of game statistics.
 *
 * @author Ayo Opuiyo
 * @version 10/18/19
 */
public class GameStats
{
    /**represents the number of games lost by the human player, so far*/
    int nlosses;
    /**represents the number of games that ended in a tie, so far*/
    int nties;
    /**represents the number of games won by the human player, so far*/
    int nwins;

    /**
     * Constructor for objects of class GameStats
     */
    public GameStats(){
        nlosses = 0;
        nties = 0;
        nwins = 0;
    }

    /**
     * Increments the number of human losses.
     *
     * @param  
     * @return void   
     */
    public void recordLoss(){
        nlosses += 1;
    }
    
    
    /** 
     *Increments the number of ties.
     */
    public void recordTie(){
        nties += 1;
    }
    
    /** 
     *Increments the number of wins.
     */
    public void recordWin(){
        nwins += 1;
    }
    
    /** 
     *Returns a textual representation of the statistics contained in this object.
     *
     *@return a textual representation of the statistics contained in this object
     */public String toString(){
        String str = "You won " + nwins + ". You lost " + nlosses + ". You tied " + nties + ".";
        
        return str;
    }
}
