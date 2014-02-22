/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generate(1, n);
    }
    ArrayList<TreeNode> generate(int start, int end)
    {
        ArrayList<TreeNode> list=new ArrayList<TreeNode>(); 
        if(start>end)
        {
            list.add(null);
        }
        for(int i=start; i<=end; i++)
        {
            ArrayList<TreeNode> left=generate( start, i-1 );
            ArrayList<TreeNode> right=generate( i+1, end );
            for(int p=0; p<left.size(); p++)
            {
                for(int q=0; q<right.size(); q++)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=left.get(p); 
                    root.right=right.get(q);
                    list.add(root);
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
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> generateTrees(int start, int end) {
    	ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
    	if(start > end) {
    		trees.add(null);
    		return trees;
    	}
    	for(int i = start; i <= end; i++) {
    		ArrayList<TreeNode> lefts = generateTrees(start, i-1);
    		ArrayList<TreeNode> rights = generateTrees(i+1, end);
    		for(TreeNode left : lefts) {
    			for(TreeNode right : rights) {
    				TreeNode root = new TreeNode(i);
    				root.left = left;
    				root.right = right;
    				trees.add(root);
    			}
    		}
    	}
    	return trees;
    }
}


































