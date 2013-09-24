package backtracking;

import java.util.Scanner;




/*

5 3 10
0.5 0.4 0.6 0.8 1.0
2 3 5 6 8

op: 0.320000


*/


public class SkippingStones{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int stones = Integer.parseInt(sc.next());
		int jump = Integer.parseInt(sc.next());
		int puddleLen = Integer.parseInt(sc.next());
		
		
		float p[] = new float[stones+2];
		int d[] = new int[stones+2];
		float dp[] = new float[stones+2];
		
		p[0] = 1;
		p[stones+1] = 1;
		d[0] = 0;
		d[stones+1] = puddleLen;
		
		
		for(int i=1; i<stones+1; i++){
			p[i] = Float.parseFloat(sc.next());
		}
		
		for(int i=1; i<stones+1; i++){
			d[i] = Integer.parseInt(sc.next());
		}
		
		for(int i=0; i<stones+2; i++){
			dp[i] = 0;
		}
		dp[0] = 1;
		
		
		
		for(int i=1; i<stones+2; i++){
			int j = i-1;
			System.out.println("new");
			while(j>=0 && d[j] >= (d[i] - jump)){
					
				if(p[i]*dp[j] > dp[i])
					dp[i] = p[i]*dp[j];
				
				--j;
				
				for(float n : dp){
					System.out.print(n+" ");
				}
				System.out.println();
				
				
			}
			
		}
		
		
		System.out.println(dp[stones+1]);
		
		
		
		
	}
	
	
}