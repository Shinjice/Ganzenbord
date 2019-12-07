import java.util.Random;
import java.util.Scanner;

public class ganzenbordv1 {
	
    private static Random random;

    public static void main(String[] args) {
        
    	Scanner pressKey = new Scanner(System.in); //key input
    	
    	random = new Random(); //given, random function imported
        int position = 1; //start position on board

        int a = g(); //method for diceroll

        while (position < 63) //while position is lower than 63, continue loop
        {
            position += a; //will add diceroll to position     
            
            if (position==23) //if position is 23 do next method
            {
                System.out.println("Youve trown " + a + ", you are now at " + position + ", GAMEOVER!");              
                return; //will return to main method
                
            } else if (position == 25||position == 45){ //25 OR 45
            	
            	System.out.println("Youve trown " + a + ", you are now at " + position + ", RESTART!, press key to restart the GAME");
            	position=1; //will set position back to 1
            	String anyKey = pressKey.nextLine(); //input key to continue
            
            } else if (position == 10||position == 20||position == 30||position == 40||position == 50||position == 60){
            	
            	int bonusJump = (position+a); //shows new position on nextline printed
            	System.out.println("Youve trown " + a + ", you are now at " + position + ", BONUSJUMP!, you are now at " + bonusJump + ", press key to trow again");
            	position+=a; //adds extra steps to position and continues 
            	String anyKey = pressKey.nextLine();
              
            } else {
            	
            	System.out.println("Youve trown " + a + ", you are now at " + position + ", no sweat, press key to trow again"); //none of condition in while loop hit? will print this
            	String anyKey = pressKey.nextLine(); 
            	
            }
            a = g();
        	}
           
        	System.out.println("You made it to position 63, YOUVE WON!"); //if while condition (pos>63) is true, it will go out of the loop and print this     
    }
        
                

    public static int g() //method for diceroll
    {
        int a = random.nextInt(6); //given
        a++; //wont trow 0to5 but 1to6
        return a; //return to main method as integer a
    }

}