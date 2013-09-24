package dp;
import java.util.ArrayList;
import java.util.List;


public class MaxSlidingWindow {	
	/** {1, 3 ,-1, -3, 5, 3, 6 ,7} **/
	
	public static void maxWin(int A[], int n, int w){
		
		int B[] = new int[6];
		List<Integer> Q = new ArrayList<Integer>();
		
		for (int i = 0; i < w; i++) {
		    while (!Q.isEmpty() && A[i] >= A[Q.get(Q.size()-1)])
		      Q.remove(Q.size()-1);
		    Q.add(i);
		  }
		 System.out.println("\n==========Q======");
		    for(int ii : Q){
				  System.out.print(ii+" ");
			  }
		
		for (int i = w; i < n; i++) {
		    B[i-w] = A[Q.get(0)];
		    while (!Q.isEmpty() && A[i] >= A[Q.get(Q.size()-1)])
		    	Q.remove(Q.size()-1);
		    while (!Q.isEmpty() && Q.get(0) <= i-w)
		    	Q.remove(0);
		    Q.add(i);
		    
		    
		    System.out.println("\n==========B======");
		    for(int ib : B)
			  System.out.print(ib+" ");
		    
		    System.out.println("\n==========Q======");
		    for(int iq : Q)
				  System.out.print(iq+" ");
			  
		    
		    
		  }
		  B[n-w] = A[Q.get(0)];
		  
		  
		  System.out.println("\n==========B======");
		    for(int i : B){
			  System.out.println(i);
		  }
	}
	
	
	
	public static void main(String [] args){
		
		int[] A = {1, 3 ,-1, -3, 5, 3, 6 ,7};
		maxWin(A, 8, 3);
	}

}
