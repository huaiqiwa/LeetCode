/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root!=null) root.next=null; 
        while(root!=null)
        {
            TreeLinkNode r=root;
            while(r!=null)
            {
                if(r.left!=null)
                {
                    if(r.right!=null) r.left.next=r.right; 
                    else r.left.next=findNext(r);
                }
                if(r.right!=null)
                {
                    r.right.next=findNext(r);
                }
                r=r.next; 
            }
            if (root.left!=null) root=root.left; 
            else if(root.right!=null) root=root.right;
            else root=root.next; 
        }
        return ;
    }
    TreeLinkNode findNext(TreeLinkNode parent)
    {
        TreeLinkNode runner=parent;
        while(runner.next!=null)
        {
            runner=runner.next;
            if(runner.left!=null) return runner.left;
            if(runner.right!=null) return runner.right;
        }
        return null; 
    }
}


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode curLevelLeftMost = root;
        TreeLinkNode nextLevelLeftMost = null;
        while(curLevelLeftMost != null) {
        	TreeLinkNode cur = curLevelLeftMost;
        	while(cur != null) {
        		TreeLinkNode first = findNextHasChild(cur);
        		if(first == null) {
        			break;
        		}
        		if(nextLevelLeftMost == null) nextLevelLeftMost = (first.left != null ? first.left : first.right);
        		TreeLinkNode second = findNextHasChild(first.next);
        		if(first.left != null && first.right != null) {
        			first.left.next = first.right;
        			if(second != null) first.right.next = (second.left != null ? second.left : second.right);
        		} else if(second != null && first.left != null) {
        			first.left.next = (second.left != null ? second.left : second.right);
        		} else if(second != null && first.right != null) {
        			first.right.next = (second.left != null ? second.left : second.right);
        		}
        		cur = second;
        	}
        	curLevelLeftMost = nextLevelLeftMost;
        	nextLevelLeftMost = null;
        }
    }
    
    private TreeLinkNode findNextHasChild(TreeLinkNode cur) {
    	if(cur == null) return null;
    	while(cur != null) {
    		if(cur.left != null || cur.right != null) return cur;
    		cur = cur.next; 		
    	}
    	return null;
    }
}



/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode curLevelLeftMost = root;
        TreeLinkNode nextLevelLeftMost = null;
        while(curLevelLeftMost != null) {
            TreeLinkNode cur = curLevelLeftMost;
            while(cur != null) {
                cur = findNextHasChild(cur);
                if(cur == null) break;
                if(nextLevelLeftMost == null) 
                    nextLevelLeftMost = (cur.left != null ? cur.left : cur.right);
                TreeLinkNode next = findNextHasChild(cur.next);
                if(cur.left != null && cur.right != null) cur.left.next = cur.right;
                if(next == null) break;
                TreeLinkNode curChild = (cur.right != null ? cur.right : cur.left);
                TreeLinkNode nextChild = (next.left != null ? next.left : next.right);
                curChild.next = nextChild;
                cur = next;
            }
            curLevelLeftMost = nextLevelLeftMost;
            nextLevelLeftMost = null;
        }
    }
    
    private TreeLinkNode findNextHasChild(TreeLinkNode cur) {
        while(cur != null) {
            if(cur.left != null || cur.right != null) return cur;
            cur = cur.next;
        }
        return null;
    }
}




























