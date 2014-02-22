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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
        if(root==null) return result; 
        ArrayList<Integer> rootValList=new ArrayList<Integer>();
        ArrayList<TreeNode> rootList=new ArrayList<TreeNode>();
        rootValList.add(root.val);
        rootList.add(root);
        result.add(rootValList);
        while(rootList.size()!=0)
        {
            ArrayList<TreeNode> children=new ArrayList<TreeNode> (); 
            ArrayList<Integer> childrenVal=new ArrayList<Integer>(); 
            for(int i=0; i<rootList.size(); i++)
            {
                TreeNode left=rootList.get(i).left; 
                if(left!=null)
                {
                children.add(left); childrenVal.add(left.val);
                }
                TreeNode right=rootList.get(i).right;
                if(right!=null)
                {
                children.add(right); childrenVal.add(right.val);
                }
            }
            rootList=new ArrayList<TreeNode>(children);
            if(childrenVal.size()!=0) result.add(childrenVal);
        }
        return result; 
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null) return results;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int curLevel = 1;
        int nextLevel = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(!queue.isEmpty()) {
        	TreeNode cur = queue.poll();
        	result.add(cur.val);
        	curLevel--;
        	if(cur.left != null) {
        		queue.offer(cur.left);
        		nextLevel++;
        	}
        	if(cur.right != null) {
        		queue.offer(cur.right);
        		nextLevel++;
        	}
        	if(curLevel == 0) {
        		results.add(result);
        		curLevel = nextLevel;
        		nextLevel = 0;
        		if(curLevel != 0) result = new ArrayList<Integer>();
        	}
        }
        return results;
    }
}





























