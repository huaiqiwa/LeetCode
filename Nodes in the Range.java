  public static int maxNum=0; 
  public static void sumRange(TreeNode root, int max, int min)
	{
		if(root==null) return ;
		if(root.val<=max && root.val>=min )
		{
			maxNum++; 
			sumRange(root.left,  max,  min); 
			sumRange(root.right, max,  min); 
		}else if(root.val<min)
		{
			sumRange(root.right, max, min);
		}else
		{
			sumRange(root.left, max, min);
		}
	}


public class Solution {
	private int count;
	public int sumRange(TreeNode root, int min, int max) {
		count = 0;
		sumRangeRecur(root, min, max);
		return count;
	}
	
	private void sumRangeRecur(TreeNode root, int min, int max) {
		if(root == null) return;
		if(root.val >= min && root.val <= max) {
			count++;
			sumRangeRecur(root.left, min, max);
			sumRangeRecur(root.right, min, max);
		} else if(root.val < min) {
			sumRangeRecur(root.right, min, max);
		} else {
			sumRangeRecur(root.left, min, max);
		}
	}
}













