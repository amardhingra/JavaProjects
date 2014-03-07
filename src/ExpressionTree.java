public class ExpressionTree {

	//Initialing the Objects required
	private MyStack<String> stack = new MyStack<String>();
	private ExpressionTreeNode root;
	
	public ExpressionTree(String[] s){
		createExpressionTree(s);
	}
	
	private void createExpressionTree(String[] s){
		
		//pushing the expression to the stack
		for (int i=0; i<s.length;i++)
			stack.push(s[i]);
		
		//setting the root by building the entire tree
		String first = stack.pop();
		this.root = buildExpression(first);
		
	}
	
	private ExpressionTreeNode buildExpression(String s){
	    	
			//creating a subroot
			ExpressionTreeNode subRoot = new ExpressionTreeNode(s);
		
			//creating the children by making another subtree is the next element is an operator
			//else adding another node
			ExpressionTreeNode treeRight;
			String s1 = stack.pop();
			if (isOperator(s1))
				treeRight = buildExpression(s1);
			else
				treeRight = new ExpressionTreeNode(s1);
	    	
			ExpressionTreeNode treeLeft;
			String s2 = stack.pop();
			if (isOperator(s2))
				treeLeft = buildExpression(s2);
			else
				treeLeft = new ExpressionTreeNode(s2);
				
			//setting the children
			subRoot.left = treeLeft;
			subRoot.right = treeRight;
			
		return subRoot;
	}
	
	public String toString(){
		return makeSubstring(root);
	}
	
	private String makeSubstring(ExpressionTreeNode e){
		//creating the subexpressions recursively
		//returns subexpression at every step
		String s;
		if (isOperator(e.data))
			s = "(" + makeSubstring(e.left) + e.data + makeSubstring(e.right) + ")";
		else
			return e.data;
		
		return s;
		
	}
	
	private static boolean isOperator(String s) {
		//checks if s is an operator
		if (s.equals("*")||s.equals("/")||s.equals("+")||s.equals("-"))
			return true;
		return false;
	}
	
	private class ExpressionTreeNode{
		
		//ExpressionTreeNode that holds data and two children
		String data;
		ExpressionTreeNode left;
		ExpressionTreeNode right;
		
		public ExpressionTreeNode(String s){
			data = s;
		}
	}
}
