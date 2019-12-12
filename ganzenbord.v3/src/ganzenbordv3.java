import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class ganzenbordv3 {

    static Scanner keyPress = new Scanner(System.in);
    static ArrayList < playerClass > playerList = new ArrayList < playerClass > ();
    static int turnNow;
    static boolean game = true;
    static int totalPlayers;

    public static void main(String[] args) {
        addPlayers();    	
        
        while (game) {
            if (turnNow >= totalPlayers) {
                turnNow = 0;
            }

            turnNow++;
            int g = diceRoll();            
            String nameTurn = playerList.get(turnNow).getName();

            if (!playerList.get(turnNow).getSkip()) {
            	if (!playerList.get(turnNow).getWell()) {
                    playerList.get(turnNow).plusSetPosition(g);

                    System.out.println(nameTurn + ", youve trown " + g + ", you are now at " + playerList.get(turnNow).getPosition() + ", press key to continue");
                    //keyPress.nextLine();
                    
                    if (playerList.get(turnNow).getPosition() == 6) {
                        playerList.get(turnNow).setPosition(12);
                        System.out.println("BRIDGE!, " + nameTurn + " you are now at " + playerList.get(turnNow).getPosition() + ", press key to continue");
                        //keyPress.nextLine();
                    }
                    if (playerList.get(turnNow).getPosition() == 19) {                                          
                        playerList.get(turnNow).setSkip();
                        System.out.println("INN!, " + nameTurn + " has to skip one turn, press key to continue");
                        //keyPress.nextLine();
                    }
                    if (playerList.get(turnNow).getPosition() == 31) {                
                    	playerList.forEach(playerList -> playerList.exitWell());
                    	playerList.get(turnNow).setWell();
                        System.out.println("WELL!, " + nameTurn + " wait for next player to hit the well before you can move on, press key to continue");
                        //keyPress.nextLine();
                    }
                    if (playerList.get(turnNow).getPosition() == 42) {
                        playerList.get(turnNow).setPosition(39);
                        System.out.println("MAZE!, " + nameTurn + " you are now at " + playerList.get(turnNow).getPosition() + ", press key to continue");
                        //keyPress.nextLine();
                    }
                    if (playerList.get(turnNow).getPosition() == 3) {                        
                        playerList.get(turnNow).setSkipThreeTurn();
                        playerList.get(turnNow).setSkip();
                        System.out.println("JAIL!, " + nameTurn + " has to skip three turns, press key to continue");
                        //keyPress.nextLine();
                    }
                    if (playerList.get(turnNow).getPosition() == 58) {
                        playerList.get(turnNow).setPosition(0);
                        System.out.println("DEATH!, " + nameTurn + " you are back at " + playerList.get(turnNow).getPosition() + ", press key to continue");
                        //keyPress.nextLine();
                    }
                    if (playerList.get(turnNow).getPosition() == 63) {
                        System.out.println("FINISH!, "+ nameTurn + " hits 63 and wins the game!");
                        game = false;                                       
                    }
                    if (playerList.get(turnNow).getPosition() > 63) {

                        int temp = playerList.get(turnNow).getPosition();
                        int backwards = ((playerList.get(turnNow).getPosition()) - 63) * 2;
                        playerList.get(turnNow).minSetPosition(backwards);
                        System.out.println("TROWN OVER 63!, " + nameTurn + " you are now at " + playerList.get(turnNow).getPosition() + ", press key to continue");
                        //keyPress.nextLine();
                    }
                }
            	else {
                    System.out.println(nameTurn + ", wait till other player hits the well before you can continue, press key to continue");
                    //keyPress.nextLine();
                }
            	

            } 
            else if (playerList.get(turnNow).getSkipTurn() > 0) {
               playerList.get(turnNow).minSkipTurn();
               System.out.println(nameTurn + ", you got to skip this turn , press key to continue");
               //keyPress.nextLine();
            } 
          	else {
                playerList.get(turnNow).exitSkip();
                System.out.println(nameTurn + ", you got to skip this turn, next turn you will be back in the game , press key to continue");
               //keyPress.nextLine();
            }                  
        }
    }

    static void addPlayers() {
        System.out.println("Ammount of players?");
        totalPlayers = keyPress.nextInt();
        System.out.println("Names of players?");

        for (int x = 0; x <= totalPlayers; x++) {
            String namePlayer = keyPress.nextLine();
            playerList.add(x, new playerClass(namePlayer));
        }
    }

    static int diceRoll() {
        Random random = new Random();
        int a = random.nextInt(6);
        a++;
        return a;
    }

}

class playerClass {
    private String name;
    private int position = 0;
    boolean skip;
    private int skipTurn = 0;
    boolean well;
    

    public playerClass(String a) {
        this.name = a;
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int a) {
        this.position = a;
    }
    public void plusSetPosition(int a) {
        this.position += a;
    }
    public void minSetPosition(int a) {
        this.position -= a;
    }    
    public boolean getSkip() {
        return skip;
    }
    public boolean exitSkip() {
        skip = false;
        return skip;
    }
    public boolean setSkip() {
        skip = true;
        return skip;
    }
    public int getSkipTurn() {
        return skipTurn;
    }
    public int setSkipThreeTurn() {
        this.skipTurn += 2;
        return skipTurn;
    }
    public int minSkipTurn() {
        this.skipTurn --;
        return skipTurn;
    }
    public boolean getWell() {
        return well;
    }
    public boolean exitWell() {
        well = false;
        return well;
    }
    public boolean setWell() {
        well = true;
        return well;
    }   
}