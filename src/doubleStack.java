
public class doubleStack {

	private int[] arr;
	private int stack1;
	private int stack2;
	
	public doubleStack(int size){
		arr = new int[size];
		stack1 = 0;
		stack2 = size-1;
	}
	
	public void push(int stackNumber, int data){
		if (stackNumber == 1){
			if (stack1+1 == stack2)
				throw new OverFlowException();
			stack1++;
			arr[stack1] = data;
		}
		if (stackNumber == 2){
			if (stack2-1 == stack1)
				throw new OverFlowException();
			stack2--;
			arr[stack2] = data;
		}
	}
	
	public int pop(int stackNumber){
		int data;
		if(isEmpty(stackNumber))
			throw new UnderFlowException();
		if (stackNumber == 1){
			data = arr[stack1];
			stack1--;
		}
		if (stackNumber == 2){
			data = arr[stack2];
			stack2++;
		}
		return data;
	}

	public boolean isEmpty(int stackNumber) {
		if ((stackNumber == 1 && stack1 >= 0)||(stackNumber == 2 && stack2 < arr.length))
			return true;
		return false;
	}
}
