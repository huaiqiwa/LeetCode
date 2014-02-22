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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> list=new ArrayList<Integer>(); 
        if(root==null) return list; 
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root); 
        while(!stack.isEmpty())
        {
            TreeNode top=stack.peek();
            if(top.left!=null)
            {
                stack.push(top.left);
            }else
            {
                while(!stack.isEmpty())
                {
                    list.add(top.val);
                    stack.pop();
                    if(top.right!=null)
                    {
                        stack.push(top.right); break; 
                    }else
                    {
                        if(!stack.isEmpty())
                        {
                            top=stack.peek(); 
                        }else break; 
                    }
                }
            }
        }
        return list; 
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null) {
        	stack.push(cur);
        	cur = cur.left;
        }
        while(!stack.empty()) {
        	cur = stack.pop();
        	result.add(cur.val);
        	if(cur.right != null) {
        		cur = cur.right;
        		while(cur != null) {
        			stack.push(cur);
        			cur = cur.left;
        		}
        	}
        }
        return result; 
    }
}

//O(1) memory solution
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null) {
        	if(cur.left != null) {
        		TreeNode pre = cur.left;
        		while(pre.right != null && pre.right != cur) {
        			pre = pre.right;
        		}
        		if(pre.right == null) {
        			pre.right = cur;
        			cur = cur.left;
        		} else {
        			pre.right = null;
        			result.add(cur.val);
        			cur = cur.right;
        		}
        	} else {
        		result.add(cur.val);
        		cur = cur.right;
        	}
        }
        return result;
    }
}
























