


class Item<T>{	
	T value;
	Item next;	
}

public class Stack<T> {
	private Item<T> top;
	
	
	public void push(T item){
		if(top!=null){
			top = new Item<T>();
			top.value = item;
		}
	}
	
	public T pop(){
		T temp = top.value;
		top = top.next;
		return temp;
	}
	
	
	public static void main(String[] a){
		Stack<Integer> myst = new Stack<Integer>();
		myst.push(23);
	}

}
