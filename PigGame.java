import java.util.*;
/**
 * Program to play the game of Pig in which two players take turns rolling dice until a target
 * goal is reached.
 * @author
 * @version
 */
public class PigGame {
    //This is a final variable-- it can't be changed! Its scope is the whole program!
    public static final int GOAL = 30;
    public static void main(String[] args) {
        //the logic of your program will go here-- you'll definitely want to use a loop!
        Scanner input = new Scanner(System.in);
        System.out.println("Show instructions? (y/n)"); //controls whether instructions shown or not
        String response1 = input.next();
        if (response1.equals("y")) {
            displayInstructions();
        }
        Player a = createPlayer(input); //creating two players
        Player b = createPlayer(input);
        while (true){
            System.out.println("Player "+a.getName()+"'s turn"); //initiating a round
            int aScore = playRound(input);
            a.addScore(aScore);
            if (a.getScore()>=GOAL){ //score checker
                System.out.println("Player "+a.getName()+" won!");
                break; //if player A wins, break the loop
            }
            System.out.println("\n--------Current Stats--------"); //separating after a round has completed
            System.out.println("Player 1 \n"+a.toString()+"\n");
            System.out.println("Player 2 \n"+b.toString());
            System.out.println("-----------------------------");
            System.out.println("Player "+b.getName()+"'s turn");
            int bScore = playRound(input); //it is the next players turn, initiates a round for player 2
            b.addScore(bScore);
            if (b.getScore()>GOAL){ //score checking
                System.out.println("Player "+b.getName()+" won!");
                break; //if player B wins, break the loop
            }
            System.out.println("\n--------Current Stats--------"); //separating rounds and updating players on the score
            System.out.println("Player 1 \n"+a.toString()+"\n");
            System.out.println("Player 2 \n"+b.toString());
            System.out.println("-----------------------------");
        }
    }
    /**
     * Displays the instructions of the game
     */
    public static void displayInstructions(){
        System.out.println("In this game, players try to be the first to score " + GOAL + " points");
        System.out.println("On each player's turn, they may roll a 6-sided die as much as they want");
        System.out.println("If they roll a 1 before they choose to finish their run, they score nothing!\n");
    }
    /**
     * Method for generating a player
     * @return the Player generated
     */
    public static Player createPlayer(Scanner input){
        System.out.println("Enter your name: ");
        String p1n = input.next();
        Player p1 = new Player(p1n);
        return p1;
    }
    /**
     * Method for playing one round of a game of Pig for one player
     * The running score is printed out at each choice of the roll
     * @param input the Scanner being used
     * @return the score for the run-- if the player ends up rolling a 1, the score is 0
     */
    public static int playRound(Scanner input){
        int run = 0;
        while (true){ //continuously keeps the game going
            int roll = (int)(Math.random()*6)+1;
            if (roll == 1){
                System.out.println("Rolled a 1 😭😭😭");
                System.out.println("Run over! Too bad :( \n");
                return 0; //returns no addition to the players score when a one is rolled
            } else {
                run += roll; //adds to the run
                System.out.println("Rolled a "+roll);
                System.out.println("Current run: "+run+"\n");
            }
            System.out.println("Continue? (y/n)");
            String responseToContinue = input.next();
            if (responseToContinue.toLowerCase().equals("no")||responseToContinue.toLowerCase().equals("n")) {
                return run; //finalizes the score, or skips this statement and continues
            }
            }
    }
}
