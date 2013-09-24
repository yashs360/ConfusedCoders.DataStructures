package dp;
import java.util.ArrayList;
import java.util.List;


public class LongestIncrSubseq {
	
	public static void longSeq(int[] in){
		
		List<Integer> Q = new ArrayList<Integer>();
		Q.add(0);
		
		for(int i: in){
			if(Q.get(Q.size()-1) <= i){
				System.out.println("added:"+i);
				Q.add(i);
			}
			else{
				while(Q.get(Q.size()-1) > i){
					System.out.println("removed:"+Q.get(Q.size()-1));
					Q.remove(Q.size()-1);
				}
				Q.add(i);
				
			}
		}
		
		
		for(int i : Q)
			System.out.println(i);
	}
	
	
	
	
	
	
	
	public static void main(String[] args){
		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		System.out.println("0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15");
		longSeq(arr);
	}

}
