package queues;


class Item{
	
	Integer data;
	Item next;
	
	public Item(){}
	
	public Item(Integer data){
		this.data = data;
	}
}


public class Queue{
	
	private Item front;
	private Item rear;
	
	private boolean isEmpty(){
		if(front == null && rear ==null)
			return true;
		else
			return false;
	}
	
	public void enqueue(Integer data){
		if(isEmpty()){
			front = rear = new Item(data);
		}
		else{
			rear.next = new Item(data);
			rear = rear.next;
		}
	}
	
	public Integer dequeue(){
		if(isEmpty())
			return null;
		else{
			int data = front.data;
			front = front.next;
			return data;
		}
	}
	
	public void printQueue(){
		Item tmp = front;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	
	public static void main(String[] a){
		Queue q = new Queue();
		q.enqueue(7);
		q.enqueue(12);
		q.enqueue(34);
		q.printQueue();
		System.out.println("Dequeued:"+q.dequeue());
		q.printQueue();
	}
	
}