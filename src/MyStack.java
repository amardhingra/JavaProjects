import java.util.ArrayList;


public class MyStack<AnyType> {

	private ArrayList<AnyType> arr;
	
	public MyStack(){
		arr = new ArrayList<AnyType>();
	}
	
	public void push(AnyType a){
		arr.add(a);
	}
	
	public AnyType pop(){
		AnyType a = arr.get(arr.size()-1);
		arr.remove(arr.size()-1);
		return a;
	}
	
	public boolean isEmpty(){
		return (arr.size()==0);
	}

}
