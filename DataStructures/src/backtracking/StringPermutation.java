package backtracking;

public class StringPermutation {
	
	public String swap(String str, int index1, int index2){
		char[] arr = str.toCharArray();
		
		char tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
		return new String(arr);
	}
	
	public void permute(String input, int startIndex, int length){
		
		if(startIndex == length-1){
			System.out.println(input);
			return;
		}
		
		for(int i=startIndex; i<length; i++){
			input = swap(input, startIndex, i);
			permute(input, startIndex+1, length);
			input = swap(input, startIndex, i);	// backtrack
		}
		
	}
	
	
	public static void main(String[] args) {
		new StringPermutation().permute("abcd", 0, 4);
		
	}

}
