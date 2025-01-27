/**
 * Class used to keep track of a Player's name and score. The logic handling of the roll system
 * of the game of Pig will be handled by the PigGame class instead.
 */
public class Player{
    //fields
    private String name="";
    private int gameScore = 0;
    /**
     * Constructor for the Player
     * @param myName the name of the Player
     */
    public Player(String myName){
        name = myName;
        gameScore = 0;
    }
    /**
     * Method to add score for a Player
     * @param myScore the amount to add in
     */
    public void addScore(int myScore){
        gameScore += myScore;
    }

    /**
     * Getter method for the score
     * @return the score of the player
     */
    public int getScore(){
        return gameScore;
    }

    /**
     * Getter method for the name
     * @return the name of the player
     */
    public String getName(){
        return name;
    }

    /**
     * toString to display the status of the Player
     */

     public String toString(){
        return ("Name: "+name+" Score: "+gameScore);
     }
}