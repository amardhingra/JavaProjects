public class MakeChange {
	
	public static int number;
	
	public static void main(String[] args)
	{
		
		number = Integer.parseInt(args[0]);
		
		if (number%5 == 0 && number >=0)
			makeChange(number, 0,0,0);
		else 
			System.out.println("Invalid number. Please only enter positive numbers divisible by 5");
	}

	public static void makeChange(int amount, int quarters, int nickels, int dimes) {
		
		//Subtracting 25 if 10 or 5 haven't been subtracted
		if (amount>=25 && nickels == 0 && dimes == 0)
			makeChange(amount - 25, quarters + 1, nickels, dimes);
		
		//subtracting 10  if 5 hasn't been subtracted
		if (amount>=10 && dimes == 0)
			makeChange(amount - 10, quarters, nickels + 1, dimes);
		
		//subtracting 5
		if (amount>=5)
			makeChange(amount - 5, quarters, nickels, dimes + 1);
		
		//printing the change if amount has reached 0
		if (amount == 0)
			print(quarters, nickels, dimes);
		
	}

	private static void print(int quarters, int nickels, int dimes) {
		
		//printing out the change
		System.out.print("Change for "+ number +":");
		for(int i= 0; i<quarters; i++)
			System.out.print(" 25 ");
		for(int j= 0; j<nickels; j++)
			System.out.print(" 10 ");
		for(int k= 0; k<dimes; k++)
			System.out.print(" 5 ");
		System.out.println("\n");
		
	}
}
