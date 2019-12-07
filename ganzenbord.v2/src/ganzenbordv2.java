import java.util.Random;
import java.util.Scanner;

public class ganzenbordv2 {
	
    private static Random random;

    public static void main(String[] args) {
        
    	Scanner pressKey = new Scanner(System.in);
    	
    	random = new Random();
        int position = 1;

        int diceRoll = g();

        while (position < 63)
        {
            position += diceRoll;        
            
            if (position==23)
            {
                System.out.println("Youve trown " + diceRoll + ", you are now at " + position + ", GAMEOVER!");              
                return;
                
            } else if (position == 25||position == 45){
            	
            	System.out.println("Youve trown " + diceRoll + ", you are now at " + position + ", RESTART!, press key to restart the GAME");
            	position=0;
            	String anyKey = pressKey.nextLine();
            
            } else if (position == 10||position == 20||position == 30||position == 40||position == 50||position == 60){
            	
            	int bonusJump = (position+diceRoll);
            	System.out.println("Youve trown " + diceRoll + ", you are now at " + position + ", BONUSJUMP!, you are now at " + bonusJump + ", press key to trow again");
            	position+=diceRoll;
            	String anyKey = pressKey.nextLine();
              
            } else {
            	
            	System.out.println("Youve trown " + diceRoll + ", you are now at " + position + ", no sweat, press key to trow again");
            	String anyKey = pressKey.nextLine();
            	
            }
            diceRoll = g();
        	}
           
        	System.out.println("You made it to position 63, YOUVE WON!");	     
    }
        
                

    public static int g()
    {
        int diceRoll = random.nextInt(6);
        diceRoll++;	        
        return diceRoll;
    }

}

	
	



