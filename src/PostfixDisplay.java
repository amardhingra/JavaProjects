import java.util.Scanner;


public class PostfixDisplay {

	public static void main(String[] args){
		
		boolean again = true;
		boolean valid = true;
		MyStack<String> stack = new MyStack<String>();
		Scanner s = new Scanner(System.in);
		
		while (again){
			
			valid = true;
			System.out.println("Please enter a postfix expression");
			System.out.println("For example \" 14 3 9 + * \" will evaluate to (14*(3+9))");
			
			String[] expressions = s.nextLine().split(" ");
			for (int i=0; i<expressions.length;i++){
				
				stack.push(expressions[i]);
				
				if (isOperator(expressions[0])||isOperator(expressions[1]))
					valid = false;
			}
					
					
			
			String exp = "";
			
			if(!stack.isEmpty())
				exp = stack.pop();
			else{
				System.out.println("Invalid stack");
				valid = false;
			}
			if(valid)
				System.out.println(buildExpression(stack, exp));
			else
				System.out.println("Invalid expression");
			
			System.out.print("Would you like to go again? (y/n) ");
			again = (s.nextLine().equals("y"));
		}
	
	}

	private static boolean isOperator(String s) {
		if (s.equals("*")||s.equals("/")||s.equals("+")||s.equals("-"))
			return true;
		return false;
	}

	private static String buildExpression(MyStack<String> stack, String s){
		String s1="",s2="";
	    
	    	s1 = stack.pop();
	    	if (isOperator(s1))
	    		s1 = buildExpression(stack, s1);
	    	
	    	s2 = stack.pop();
	    	if (isOperator(s2))
	    		s2 = buildExpression(stack, s2);	
	    	
	    s = "(" + s2 + s + s1 + ")";
		return s;
	}
	
}
