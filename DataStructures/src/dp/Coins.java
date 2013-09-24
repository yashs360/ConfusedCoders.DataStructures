package dp;

public class Coins {
	
	public static void getMinCoins(int[] val, int S, int N){
		
		int min[] = new int[S+1];
		for(int i=0; i<min.length; i++)
			min[i]= Integer.MAX_VALUE;
		
		min[0] = 0;
		
		for(int i=1; i<=S; i++)
			for(int j=0; j<N; j++){
				
				if(val[j]<=i &&  min[i-val[j]]+1 < min[i]){
					System.out.println("min["+i+"] set: min["+(i-val[j])+"] = "+(min[i-val[j]]+1));
					min[i] = min[i-val[j]]+1;
				}
			}
		
		
		for(int i=0; i< min.length; i++)
			System.out.println(i+" => "+min[i]);
	}
	
	

	
	public static void main(String[] args){		
		int[] val = {1,3,5};		
		getMinCoins(val, 11, 3);
	}

}
