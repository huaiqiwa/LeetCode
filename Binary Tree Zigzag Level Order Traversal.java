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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
         ArrayList<ArrayList<Integer>> list=new  ArrayList<ArrayList<Integer>>(); 
         if(root==null) return list; 
         Stack<TreeNode> T=new Stack<TreeNode>(); 
         Stack<TreeNode> S=new Stack<TreeNode>(); 
         ArrayList<Integer> sub=new ArrayList<Integer>(); 
         T.push(root);
         boolean reverse=false; 
         while(!T.isEmpty())
         {
             TreeNode top=T.pop();
             sub.add(top.val);
             if(!reverse)
             {
                 if(top.left!=null) S.push(top.left);
                 if(top.right!=null) S.push(top.right);
             }else
             {
                 if(top.right!=null) S.push(top.right);
                 if(top.left!=null) S.push(top.left);
             }
             if(T.isEmpty())
             {
                 list.add(sub);
                 T=S;
                 S=new Stack<TreeNode>();
                 reverse=!reverse; 
                 sub=new ArrayList<Integer>(); 
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> cur = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        boolean isLeftToRight = true;
        cur.push(root);
        while(!cur.isEmpty()) {
        	TreeNode curNode = cur.pop();
        	result.add(curNode.val);
        	if(isLeftToRight) {
        		if(curNode.left != null) next.push(curNode.left);
        		if(curNode.right != null) next.push(curNode.right);
        	} else {
        		if(curNode.right != null) next.push(curNode.right);
        		if(curNode.left != null) next.push(curNode.left);
        	}
        	if(cur.isEmpty()) {
        		results.add(result);
        		Stack<TreeNode> temp = cur;
        		cur = next;
        		next = temp;
        		isLeftToRight = !isLeftToRight;
        		if(!cur.isEmpty()) result = new ArrayList<Integer>();
        	}
        }
        return results;
    }
}

























