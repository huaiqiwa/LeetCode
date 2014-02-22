TreeNode pre; 
TreeNode head; 
static void tree2doublylinkedlist(TreeNode root)
	{
		if(root==null) return ; 
		tree2doublylinkedlist(root.left);
		root.left=pre;
		if(pre==null) head=root; 
		else pre.right=root; 
		pre=root; 
		TreeNode right=root.right;
		//those two lines ensure that it is a circular linked list
		//if we don't make it as a circle, we could delete these two lines
		head.left=root; 
		root.right=head; 
		
		tree2doublylinkedlist(root.right);  
	}
	
private TreeNode pre;
private TreeNode head;
public void treeToDoubleLinkedList(TreeNode root) {
	if(root == null) return;
	treeToDoubleLinkedList(root.left);
	if(pre == null) head = root;
	else {
		pre.right = root;
		root.left = pre;
	}
	pre = root;
	TreeNode rtree = root.right;
	head.left = root;
	root.right = head;
	treeToDoubleLinkedList(rtree);
}