public class Solution
{
public static Result maxResult; 
  static class TreeNode
	{
		int val; 
		TreeNode left; 
		TreeNode right;
		TreeNode(int value)
		{
			val=value; 
			left=null; 
			right=null; 
		}
	}
	static class Result
	{
		TreeNode child; 
		int num; 
		Result(int n)
		{
			num=n; 
			child=null; 
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a=new TreeNode(0);
		TreeNode b=new TreeNode(20);
		TreeNode c=new TreeNode(9);
		TreeNode d=new TreeNode(4);
		TreeNode e=new TreeNode(12);
		a.left=b; 
		a.right=c; 
		c.left=d; 
		c.right=e; 
		maxResult=new Result(Integer.MIN_VALUE); 
		findLargestBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(maxResult.num);
	}

/*
if it is a BST, then return the number of nodes
else return -1; 
*/
	
    static int findLargestBST(TreeNode root, int min, int max)
    {
        if(root==null) return 0; 
        if(root.val>min && root.val<max)
        {
            int left=findLargestBST(root.left, min, root.val);
            int right=findLargestBST(root.right, root.val, max);
            if(right==-1 || left==-1) return -1;
            int total=left+right+1;
            if(total>maxResult.num)
            {
            	maxResult.num=total;
            	maxResult.child=root; 
            }
            return left+right+1; 
        }
        return -1;
    }
}


public class Solution {
	private int min;
	private int max;
	private int maxSize;
	private TreeNode maxNode;
	public int findLargestBSTSubtree(TreeNode root) {
		maxSize = 0;
		maxNode = null;
		findLargestBST(root);
		return maxSize;
	}
	
	private int findLargestBST(TreeNode root) {
		if(root == null) return 0;
		int left = findBSTSubtree(root.left);
		if(left == -1 || (left != 0 && root.val <= max)) return -1;
		int curMin = (left == 0 ? root.val : min); 
		int right = findBSTSubtree(root.right);
		if(right == -1 || (right != 0 && root.val >= min)) return -1;
		int curMax = (right == 0 ? root.val : max);
		min = curMin;
		max = curMax;
		int totalSize = left+right+1;
		if(totalSize > maxSize) {
			maxSize = totalSize;
			maxNode = root;
		}
		return totalSize;
	}
}































