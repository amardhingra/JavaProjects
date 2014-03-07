import java.util.Scanner;


public class PostfixDisplay {

	public static void main(String[] args){
		
		//initializing the variables
		boolean again = true;
		boolean valid;
		Scanner s = new Scanner(System.in);
		ExpressionTree e;
		
		while (again){
			valid = true;
			
			//obtaining the expression
			System.out.println("Please enter a postfix expression");
			System.out.println("For example \" 14 3 9 + * \" will evaluate to (14*(3+9))");
			
			//splitting the string to a String[] and checking that the first two entries are 
			//operands and the last is an operator
			String[] lineArr = s.nextLine().split(" ");
			if (!isOperator(lineArr[lineArr.length-1]) 
					|| isOperator(lineArr[0]) || isOperator(lineArr[1]))
				valid = false;
			
			//obtaining the expressiontree if the statement appears valid
			if (valid){
				try{
					e = new ExpressionTree(lineArr);
					System.out.println(e);
				}
				catch(ArrayIndexOutOfBoundsException error){
					System.out.println("Invalid expression tree");
				}
			

			}
			else
				System.out.println("Invalid expression tree");

			System.out.print("Would you like to go again? (y/n) ");
			again = (s.nextLine().equals("y"));
		}
	
	}
	private static boolean isOperator(String s) {
		//checking if s is an operand
		if (s.equals("*")||s.equals("/")||s.equals("+")||s.equals("-"))
			return true;
		return false;
	}
	
}
