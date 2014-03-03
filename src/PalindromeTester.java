import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class PalindromeTester {

	public static void main(String[] args) throws FileNotFoundException{
		
		File palindromes = new File("palindromes.txt");
		Scanner s = new Scanner(palindromes);
		
		while (s.hasNext()){
			String line = s.nextLine();
			String linenew = line.replaceAll("\\W", "");
			linenew = linenew.toLowerCase();
			boolean isPalindrome = checkPalindrome(linenew);
			if(isPalindrome)
				System.out.println("\"" + line + "\" is a palindrome");
			else
				System.out.println("\"" + line + "\" is not a palindrome");
		}
	}

	private static boolean checkPalindrome(String line) {
		
		int length = line.length();
		MyStack<Character> stack = new MyStack<Character>();
		
    	for (int i=0;i<length;i++)
    		stack.push(new Character(line.charAt(i)));
    	
    	for(int i=0;i<length;i++){
    		Character c = stack.pop();
    		if (c.charValue()!=line.charAt(i))
    			return false;
    	}
    	
	    return true;
	}
}
