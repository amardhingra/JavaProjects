
public class MontyHallMain {
	public static void main(String[] args)
	{
		//setting the number of trials
		int numberOfTrials = 1000;
		
		//creating a MontyPython object where the Player switches doors
		MontyHall switcher = new MontyHall(numberOfTrials, "switch");
		
		//creating a MontyPython object where player doesn't switch
		MontyHall same = new MontyHall(numberOfTrials, "same");
		
		//running simulations of both objects
		System.out.println(switcher.numberOfWins() + " wins switching!");
		System.out.println(same.numberOfWins() + " wins not switching!");
		
	}
}
