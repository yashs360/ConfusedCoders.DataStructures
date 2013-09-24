package tree;

class Node{
	boolean isLeaf;
	Node[] edges = new Node[26];
}

public class Trie{
	Node root = new Node();
	
	public void insert(String in){
		if(null==in)
			return;
		
		int len = in.length();
		
		if(len==0)
			return;
		
		int tmpLen = len;
		int index = 0;
		Node tmp = root;
		while(len>0){
			index = getIndex(in.charAt(tmpLen-len));
			if(tmp.edges[index]==null)
				tmp.edges[index] = new Node();
			
			tmp = tmp.edges[index];
			len--;
		}
		tmp.isLeaf = true;
		
	}
	
	
	
	public int lcp(String in){
		if(null==in)
			return -1;
		
		int len = in.length();
		
		if(len==0)
			return -1;
		
		int index = 0;
		int tmpLen = len;
		Node tmp = root;
		int lcpLen=0;
		while(len>0){
			index = getIndex(in.charAt(tmpLen-len));
			if(tmp.edges[index]==null){
				return lcpLen;
			}
			
			tmp = tmp.edges[index];
			len--;
			lcpLen++;
		}
		
		
		return lcpLen;
	}
	
	private int getIndex(Character ch){
		
		if(ch>='a' && ch<='z')
			return ch - 'a';
		else if(ch>='A' && ch<='Z')
			return ch - 'A';
		else return -1;
		
	}
	
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("ababaa");
		System.out.println(t.lcp("abaa"));
		System.out.println(t.lcp("acdf"));
		System.out.println(t.lcp("ababaa"));
	}
}