import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PalindromeTester {

	public static void main(String[] args){
		
		Scanner s;
		
		try{
			//trying to create and read from the file line by line
			File palindromes = new File(args[0]);
			s = new Scanner(palindromes);
			while (s.hasNext()){
				String line = s.nextLine();
				
				//replacing all whitespaces and punctuation and coverting to lowercase
				String linenew = line.replaceAll("\\W", "");
				linenew = linenew.toLowerCase();
				
				//checking if line is palindrome and printing the result
				boolean isPalindrome = checkPalindrome(linenew);
				if(isPalindrome)
					System.out.println("\"" + line + "\" is a palindrome\n");
				else
					System.out.println("\"" + line + "\" is not a palindrome\n");
			}
		}
		//handling errors
		catch(FileNotFoundException e){
			System.out.println("That is an invalid filename. Please try again with a valid filename.");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Please input a filename as a command line argument");
		}
		
	}

	private static boolean checkPalindrome(String line) {
		
		int length = line.length();
		//initializing the stack
		MyStack<Character> stack = new MyStack<Character>();
		
		//pushing every character to the stack
    	for (int i=0;i<length;i++)
    		stack.push(new Character(line.charAt(i)));
    	
    	//getting the word in reverse and comparing it
    	for(int i=0;i<length;i++){
    		Character c = stack.pop();
    		if (c.charValue()!=line.charAt(i))
    			return false;
    	}
    	//returning true if word is palindrome
	    return true;
	}
}
