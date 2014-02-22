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
		a.left=new TreeNode(5);
		a.right=new TreeNode(1);
		maxResult=new Result(Integer.MIN_VALUE);
		maxResult.child=null; 
		Result result=findLargestBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(maxResult.num);
	}
	
    static Result findLargestBST(TreeNode root, int min, int max)
    {
        if(root==null)
        {
        	Result r=new Result(0);
        	return r; 
        }
        if(root.val>min && root.val<max)
        {
            Result left=findLargestBST(root.left, min, root.val);
            TreeNode leftChild=left.child;
            Result right=findLargestBST(root.right, root.val, max);
            TreeNode rightChild=right.child;
            TreeNode parent=new TreeNode(root.val);
            parent.left=leftChild;
            parent.right=rightChild;
            int total=left.num+right.num+1;
            if(total>maxResult.num)
            {
            	maxResult=new Result(total);
            	maxResult.child=parent;
            }
            Result result=new Result(total);
            result.child=parent; 
            return result; 
        }else
        {
        	findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        	Result result=new Result(0);
        	return result; 
        }
    }

}

public class Solution {
	private Result maxResult;
	public int findLargestBST(TreeNode root) {
		maxResult = new Result(-1, null);
		findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return maxResult.result;
	}
	
	private Result findLargestBST(TreeNode root, int min, int max) {
		if(root == null) return new Result(0, null);
		if(root.val > min && root.val < max) {
			Result left = findLargestBST(root.left, min, root.val);
			Result right = findLargestBST(root.right, root.val, max);
			TreeNode parent = new TreeNode(root.val);
			parent.left = left.node;
			parent.right = right.node;
			int total = left.result+right.result+1;
			Result curResult = new Result(total, parent);
			if(total > maxResult.result) maxResult = curResult;
			return curResult;
		} else {
			findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
			return new Result(0, null);
		}
	}
	
	private class Result {
		int result;
		TreeNode node;
		Result(int result, TreeNode node) {
			this.result = result;
			this.node = node;
		}
	}
}

























