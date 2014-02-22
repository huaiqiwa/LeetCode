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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(inorder.length==0 && postorder.length==0) return null; 
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>(); 
        for(int i=0; i<inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return  find(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map); 
    }
    TreeNode find(int[] inorder, int istart, int iend, int [] postorder, int pstart, int pend, HashMap<Integer, Integer> match)
    {
        if(istart>iend || pstart>pend) return null; 
        TreeNode root=new TreeNode(postorder[pend]);
        int indexI=match.get(postorder[pend]);
        root.left=find(inorder, istart, indexI-1, postorder, pstart, pstart+(indexI-istart)-1, match); 
        root.right=find(inorder, indexI+1, iend, postorder, pstart+(indexI-istart), pend-1, match);
        return root; 
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder.length == 0) return null;
        HashMap<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
        	inorderIndex.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inorderIndex);
    }
    
    private TreeNode buildTree(int[] inorder, int istart, int iend, 
    	int[] postorder, int pstart, int pend, HashMap<Integer, Integer> inorderIndex) {
		if(istart > iend) return null;
		int div = postorder[pend];
		int inIndex = inorderIndex.get(div);
		TreeNode node = new TreeNode(div);
		node.left = buildTree(inorder, istart, inIndex-1, postorder, pstart, pstart+(inIndex-1-istart), inorderIndex);
		node.right = buildTree(inorder, inIndex+1, iend, postorder, pstart+(inIndex-istart), pend-1, inorderIndex);
		return node;
    }
}



























