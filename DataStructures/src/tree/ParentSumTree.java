package tree;

import common.TreeNode;



public class ParentSumTree {
	
	
	
	
	public void printTree(TreeNode node){
		
		if(node ==null)
			return;
		
		printTree(node.left);
		System.out.println(node.data);
		printTree(node.right);
		
		
	}
	
	
	public int parentSum(TreeNode node){
		if(node==null)
			return 0;
		
		if(node.left ==null && node.right==null)
			return node.data;
		
		int leftdata = parentSum(node.left);
		int rightdata = parentSum(node.right);
		node.data = leftdata + rightdata;
		return node.data;
	}
	
	
	public int parentSumPlusItself(TreeNode node){
		if(node==null)
			return 0;
		
		int leftdata = parentSum(node.left);
		int rightdata = parentSum(node.right);
		node.data += leftdata + rightdata;
		return node.data;
	}
	
	public static void main(String[] args) {
		
		/*
		  20
		 /  \
		 40   30
		 /   \   /  \
		50 30   10 40
		 */
		
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(40);
		root.right = new TreeNode(30);
		
		root.left.left = new TreeNode(50);
		root.left.right = new TreeNode(30);
		
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(40);
		
		ParentSumTree o = new ParentSumTree();
		o.printTree(root);
		o.parentSum(root);
		System.out.println();
		o.printTree(root);
		
	}

}
