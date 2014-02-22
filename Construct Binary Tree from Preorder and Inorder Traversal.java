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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(preorder.length==0 && inorder.length==0) return null; 
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++)
        {
            map.put(inorder[i], i); //map value and index, so we can easy find the right one. 
        }
        return find(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    TreeNode find(int [] preorder, int pstart, int pend, int []inorder, int istart, int iend, HashMap<Integer, Integer> match)
    {
        if(pstart>pend || istart>iend) return null; 
        TreeNode root=new TreeNode(preorder[pstart]);
        int indexI=match.get(preorder[pstart]);
        root.left=find(preorder, pstart+1, pend-(iend-indexI), inorder, istart, indexI-1, match);
        root.right=find(preorder, pend-(iend-indexI)+1, pend, inorder, indexI+1, iend, match);
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0) return null;
        HashMap<Integer, Integer> inorderIndex = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
        	inorderIndex.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inorderIndex);
    }
    
    private TreeNode buildTree(int[] preorder, int pstart, int pend, 
    	int[] inorder, int istart, int iend, HashMap<Integer, Integer> inorderIndex) {
    	if(istart > iend) return null;
    	int div = preorder[pstart];
    	int inIndex = inorderIndex.get(div);
    	TreeNode node = new TreeNode(div);
    	node.left = buildTree(preorder, pstart+1, pend-(iend-inIndex), inorder, istart, inIndex-1, inorderIndex);
    	node.right = buildTree(preorder, pend-(iend-inIndex)+1, pend, inorder, inIndex+1, iend, inorderIndex);
    	return node;	
    }
}

























