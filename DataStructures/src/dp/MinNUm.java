package dp;

public class MinNUm {
	
	public static int min(int a, int b){
		
		int k = (a-b)>>31;
		System.out.println("k"+k);
		return (a + (k*(a-b)));
	}

	
	public static void main(String[] args) {
		System.out.println(min(15,15));
	}
}
