package string;
import java.util.Arrays;


public class StringUtil {
	
	public static boolean containsDuplicateChars(String input){
		
		if(null == input)
			return false;
		
		input = input.toLowerCase();		
		int flag = 0;
		
		for(char ch : input.toCharArray()){
			if((flag & (1 <<(int)(ch-'a'))) == 0){		
				flag = flag | (1 <<(int)(ch-'a'));
			}
			else return true;
		}
		
		return false;
	}
	
	
	
	public static String removeDuplicateChars(String input){
		
		
		if(null == input)
			return null;
		
		input = input.toLowerCase();
		char[] inArr = input.toCharArray();
		
		int flag = 0;
		int incrIndex = 0, swapIndex =0;
		char tmp;
		
		for(incrIndex=0; incrIndex < inArr.length; incrIndex++){
			if((flag & (1 <<(int)(inArr[incrIndex]-'a'))) == 0){		
				flag = flag | (1 <<(int)(inArr[incrIndex]-'a'));
				
				/** Bring all the unique characters to front **/
				
					tmp = inArr[incrIndex];
					inArr[incrIndex] = inArr[swapIndex];
					inArr[swapIndex] = tmp;
					swapIndex++;							
			}			
		}
		
		return String.valueOf(Arrays.copyOfRange(inArr, 0,swapIndex));
	}
	
	
	
	public static String reverse(String input){
		
		if(null==input)
			return null;		
		
		char[] inArr = input.toCharArray();
		char tmp;
		int lastIndex = inArr.length - 1;
		int frontIndex=0;
		
		while(frontIndex<=lastIndex){
			tmp = inArr[frontIndex];
			inArr[frontIndex]=inArr[lastIndex];
			inArr[lastIndex] = tmp;	
			frontIndex++;
			lastIndex--;
		}
		
		return new String(inArr);
	}
	
	
	
	public static boolean checkAnagram(String firstString, String secondString){
		
		if(null==firstString || null== secondString)
			return false;
		
		if(firstString.length()!=secondString.length())
			return false;
		
		char[] firstArr = firstString.toCharArray();
		char[] secondArr = secondString.toCharArray();
		
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);
		
		for(int index=0; index<firstArr.length; index++){
			if(firstArr[index]!=secondArr[index])
				return false;
		}		
		
		return true;
	}
	
	
	
	public static void main(String[] args){
		System.out.println(StringUtil.checkAnagram("aergasebhjdcs","aergassebhjdc"));
	}

}
