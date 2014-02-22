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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
        if(root==null) return result; 
        ArrayList<Integer> p=new ArrayList<Integer>();
        path(result, p, root, sum);
        return result; 
    }
    void path(ArrayList<ArrayList<Integer>> result, ArrayList<Integer>p, TreeNode root, int sum)
    {
        if(root==null) return; 
        if(root.left==null && root.right==null)
        {
            if(root.val==sum) 
            {
            p.add(root.val);
            result.add((ArrayList<Integer>)p.clone());
            p.remove(p.size()-1);
            }
            return ; 
        }
        p.add(root.val); 
        path(result, p, root.left, sum-root.val);
        path(result, p, root.right, sum-root.val);
        p.remove(p.size()-1);
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	pathSum(root, 0, sum, result, results);
    	return results;	    
    }
    
    private void pathSum(TreeNode root, int curSum, int sum, 
    	ArrayList<Integer> result, ArrayList<ArrayList<Integer>> results) {
    	if(root == null) return;
    	curSum += root.val;
    	result.add(root.val);
    	if(root.left == null && root.right == null) {
    		if(curSum == sum) results.add(new ArrayList<Integer>(result));
    		result.remove(result.size()-1);
    		return;
    	}
    	pathSum(root.left, curSum, sum, result, results);
    	pathSum(root.right, curSum, sum, result, results);
    	result.remove(result.size()-1);
    }
}



























