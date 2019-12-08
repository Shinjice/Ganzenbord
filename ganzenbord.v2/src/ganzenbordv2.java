import java.util.Random; //importing lib for random function
import java.util.Scanner; //import keyboard input
import java.util.ArrayList; //import array function

public class ganzenbordv2 { 

	static Scanner keyPress = new Scanner(System.in); //imported fcn from lib
	static ArrayList <playerClass> playerList = new ArrayList <playerClass> (); //making araylist for playerclass
	static int turnNow; //turn player
	static boolean game = true; //boolean to set game in play or not	
	static int totalPlayers; //integer for total of players
	
	public static void main(String[] args) 
	{
		addPlayers(); //will do function in separate function
		
		while(game) //while loop while game = true
		{
			if (turnNow >= totalPlayers)  //turn starts at 0 
			{
				turnNow = 0; //when turn is bigger than totalplayers, start turn at over at 0, so 4 players, 4 turns, 1234 back to 1234
			}
			
			turnNow++; //turn + 1 = player1, turn + 2 (second whileloop) = player 2
			
			int g = diceRoll(); //int g initialized will do function diceRoll if called			
			
			playerList.get(turnNow).plusSetPosition(g);  //get player out playerlist based on parameter "turn", so turn 1 is player 1, will add dice trow to position of this player
	        System.out.println(playerList.get(turnNow).getName() + " , youve trown " + g + ", you are now at " + playerList.get(turnNow).getPosition()+", press key to continue"); //prints out info, gettin info out of playerclass array
	        keyPress.nextLine();
	        
	        if(playerList.get(turnNow).getPosition() == 10 || playerList.get(turnNow).getPosition() == 20 ||playerList.get(turnNow).getPosition() == 30 || playerList.get(turnNow).getPosition() == 40 || playerList.get(turnNow).getPosition() == 50 ||playerList.get(turnNow).getPosition() == 60) 
	        {
	        	playerList.get(turnNow).plusSetPosition(g); //will add diceRoll to position and stored in PlayerClass array
	        	System.out.println("BONUSJUMP!, "+ playerList.get(turnNow).getName() +" is now at " + playerList.get(turnNow).getPosition()+", press key to continue");
	        	keyPress.nextLine();
	        }
	        if(playerList.get(turnNow).getPosition() == 25 || playerList.get(turnNow).getPosition() == 45) 
	        {
	        	playerList.get(turnNow).setPosition(0);	        	
	        	System.out.println("RESTART!, "+playerList.get(turnNow).getName()+" you are now at " + playerList.get(turnNow).getPosition() + ", press key to restart continue");
	        	keyPress.nextLine();
	        }
	        if (playerList.get(turnNow).getPosition() == 23)
			{
	        	game= false; //position is 23? game is turned false and and will quit, while loop is nu false and wont conti
	        	System.out.println("You are on 23, too bad, Game Over!");
	        }
	        if (playerList.get(turnNow).getPosition() == 63) 
	        {
	        	System.out.println(playerList.get(turnNow).getName() + " hits 63 and wins the game!");	
	        	game= false;
	        		        	
	        }
	        if (playerList.get(turnNow).getPosition() > 63) //when passed 63, will go position backwards
	        {
	       	   	
	        	int temp = playerList.get(turnNow).getPosition(); 
	        	int backwards = ((playerList.get(turnNow).getPosition()) - 63) * 2;
	        	playerList.get(turnNow).minSetPosition(backwards);
	        	System.out.println("OVER 63!, "+ playerList.get(turnNow).getName() +" you are now at " + playerList.get(turnNow).getPosition() + ", press key to restart continue");	
	        	keyPress.nextLine();
	        }
		}
	}
	
	static void addPlayers() //player add method
	{
		System.out.println("Ammount of players?");
		totalPlayers = keyPress.nextInt(); //input will stored in totalplayers
		System.out.println("Names of players?");
		
		for (int x = 0; x<=totalPlayers; x++) //for loop, will start at 0, while x <= totalPlayers otherwise add 1 to x and cycle again.
		{
			String namePlayer = keyPress.nextLine(); //stores keyboard input in string
			playerList.add(x, new playerClass(namePlayer)); //add function of name to playerClass, enter names till for loop is done
			
		}
	}
	
	static int diceRoll() //method for diceroll
    {
        Random random = new Random(); //given, random function imported from lib
		int a = random.nextInt(6); //given
        a++; //wont trow 0to5 but 1to6
        return a; //return int a to placeholder g in main
    }	

}

class playerClass //class to store player information
{
	private String name; //initialized player with a name and position, so every player wil have a name and a position stored in Playerclass arraylist
	private int position = 0;
	
	public playerClass(String a) { //add names from addplayer function to players in arraylist
		this.name = a;
	}
	public String getName() {
		return name; //when called getname, function calls name from arraylist, and return name to placeholder in main
	}
	public void setName(String a) { //when called setName, string a = 
		this.name = a;
	}
	public int getPosition() { //when called getPosition, function calls current position of player, and return name to placeholder in main
		return position;
	}
	public void setPosition(int a) { //when function is called, placeholder in main function will fill int a. In this function int a will be set equal to position in PlayerClass and stores it
		this.position = a;
	}
	public void plusSetPosition(int a) {//when function is called, plusSetPositon placeholder in main function will go to int a and add int a to position in Playerclass and stores it
		this.position += a;
	}
	public void minSetPosition(int a) {
		this.position -= a;
	}
	
}