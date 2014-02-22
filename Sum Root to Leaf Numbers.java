/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return 0; 
        ArrayList<Integer> result=new ArrayList<Integer>();
        find(root, 0, result );
        int sum=0; 
        for(Integer i: result)
        {
            sum+=i;
        }
        return sum; 
    }
    void find(TreeNode root, int sum, ArrayList<Integer> result )
    {
        if(root==null) return ; 
        sum=sum*10+root.val;
        if(root.left==null && root.right==null)
        {
            result.add(sum); return; 
        }
        if(root.left!=null)
        {
            find(root.left, sum, result);
        }
        if(root.right!=null)
        {
            find(root.right, sum, result);
        }
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        sumNumbers(root, 0, sum);
        return sum[0];
    }
    
    private void sumNumbers(TreeNode root, int anum, int[] sum) {
    	if(root == null) return;
    	int nextNum = anum*10 + root.val;
    	if(root.left == null && root.right == null) {
    		sum[0] += nextNum;
    		return;
    	}
    	sumNumbers(root.left, nextNum, sum);
    	sumNumbers(root.right, nextNum, sum);
    }
}


public class Solution {
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        sumNumbers(root, 0, sum);
        return sum[0];
    }
    
    private void sumNumbers(TreeNode root, int num, int[] sum) {
        if(root == null) return;
        num = num*10 + root.val;
        if(root.left == null && root.right == null) {
            sum[0] += num;
            return;
        }
        sumNumbers(root.left, num, sum);
        sumNumbers(root.right, num, sum);
    }
}
























