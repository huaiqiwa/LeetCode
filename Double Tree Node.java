public static void doubleTree(TreeNode root) {
	if(root==null) return ;
	TreeNode newNode=new TreeNode(root.val);
	newNode.left = root.left;
	root.left = newNode;
	doubleTree(newNode.left);
	doubleTree(root.right);
}
