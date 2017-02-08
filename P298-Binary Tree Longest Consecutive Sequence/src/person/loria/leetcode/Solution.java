package person.loria.leetcode;

  
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null)
        	return 0;
        return triverseTree(root, 1);
    }
    
    int triverseTree(TreeNode root, int length) {
    	int left = 0,right = 0;
    	if(root.left!=null)
    		if(root.left.val == root.val + 1)
    			left = triverseTree(root.left, length+1);
    		else
    			left = triverseTree(root.left, 1);
    	if(root.right!=null)
    		if(root.right.val == root.val + 1)
    			right = triverseTree(root.right, length+1);
    		else
    			right = triverseTree(root.right, 1);
    	return Math.max(length, Math.max(left, right));
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}