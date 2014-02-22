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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode pre = null;
        while(!stack.empty()) {
        	TreeNode cur = stack.peek();
        	if(pre == null || pre.left == cur || pre.right == cur) {
        		if(cur.left != null) stack.push(cur.left);
        		else if(cur.right != null) stack.push(cur.right);
        		else {
        			result.add(cur.val);
        			stack.pop();
        		}
        	} else if(cur.left == pre) {
        		if(cur.right != null) stack.push(cur.right);
        		else {
        			result.add(cur.val);
        			stack.pop();
        		}
        	} else if(cur.right == pre) {
        		result.add(cur.val);
        		stack.pop();
        	}
        	pre = cur;
        }
        return result;
    }
}