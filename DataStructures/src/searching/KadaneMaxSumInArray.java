package searching;

public class KadaneMaxSumInArray {
	
	
	
	/** Kadane algo must have atleast one non -ve num **/
	public int maxSumKadane(int[] in){
		
		int sum=0, lastMaxSum=0;
		
		for(int num : in){
			sum += num;
			
			if(sum < 0){
				sum=0;
			}			

			lastMaxSum = max(lastMaxSum, sum);
			
			System.out.println("sum:"+sum+",lastMaxSum:"+lastMaxSum);
		}
		
		return lastMaxSum;
	}
	
	private int max(int num1, int num2){
		return (num1>num2) ? num1 : num2;
	}
	
	
	
	
	/** Handles all -ve array elements **/
	public int maxSumApproach2(int[] in){
		int maxSum=in[0], lastMaxSum = in[0];
		
		for(int i=1; i<in.length; i++){
			maxSum = max(maxSum+in[i], in[i]);	// instead of initializing to zero for -ve val, init it to the max of both :)
			lastMaxSum = max(lastMaxSum, maxSum);
			
			System.out.println("maxSum:"+maxSum+",lastMaxSum:"+lastMaxSum);
		}
		
		return lastMaxSum;
		
	}
	
	
	
	public static void main(String[] args) {
		int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};
		int[] arr2 = {-2, -3, -4, -1, -2, -1, -5, -3};
		
		System.out.println("Kadane:"+new KadaneMaxSumInArray().maxSumKadane(arr1));
		System.out.println("Approach2:"+new KadaneMaxSumInArray().maxSumApproach2(arr1));
		
		System.out.println("Kadane:"+new KadaneMaxSumInArray().maxSumKadane(arr2));
		System.out.println("Approach2:"+new KadaneMaxSumInArray().maxSumApproach2(arr2));
	}
	
	
}
