
public class MontyHall {
	
	//initiating the variables
	private int trials;
	private int playerDoor;
	private String strategy;
	private int prizeDoor;
	private int revealedDoor;
	
	public MontyHall(int numberOfTrials, String userStrategy)
	{
		//giving the variables user defined values
		trials = numberOfTrials;
		strategy = userStrategy;
	}
	
	public int numberOfWins()
	{
		//public class that allows the user to find the number of wins
		//starting the counter at 0
		int wins = 0;
		//starting the loop
		for(int i = 0; i<=trials; i++)
		{
			//running the simulation
			runSimulation();
			if(playerDoor==prizeDoor)
			{
				//increasing the win counter if the player wins
				wins++;
			}
		}
		return wins;
	}
	
	private void runSimulation()
	{
		//randomly setting a prize door and player door
		prizeDoor = doorPicker();
		playerDoor = doorPicker();
		
		//revealing one of the doors which doesn't have the prize
		revealedDoor = doorRevealer();
		
		if(strategy.equals("switch"))
		{
			//switching the players door if the player always switches
			doorSwitcher();
		}
			
	}
	
	private void doorSwitcher() 
	{
		//switching to the last available door (sum from 1 to 3 = 6)
		playerDoor = 6-playerDoor-revealedDoor;
				
	}

	private int doorPicker()
	{
		//returns a random number from 1 to 3 inclusive
		return (int) (Math.random()*3 + 1);
	}
	
	private int doorRevealer()
	{
		//sets initial conditions for loop
		boolean returned = false;
		int door = 0;
		
		while(!returned)
		{
			door = doorPicker();
			if(door != playerDoor & door != prizeDoor)
			{
			//if the door hasn't been picked and doesn't have a prize
			//break the loop
				returned = true;
			}
		}
		return door;
	}
	
	
}
