package permutation;
import java.util.ArrayList;

public class Permutation {

	
	public static ArrayList<String> generateCombinations(String[] input) {

		ArrayList<String> perm = new ArrayList<String>();
		ArrayList<String> tmpList = null;
		String word;
		perm.add("");
		
		for (int i = 0; i < input.length; i++) {
			tmpList = new ArrayList<String>();
			
			word = input[i];
			for (Character ch : word.toCharArray()) {
				for (String str : perm) {
					tmpList.add(str + ch);
				}
			}

			perm = tmpList;
		}
		return perm;
	}

}
