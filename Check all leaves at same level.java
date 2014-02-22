private static leafDepth;

public static boolean checkLeavesSameLevel(TreeNode root) {
	leafDepth = 0;
	return checkLevel(root, 0);
}

private static boolean checkLevel(TreeNode root, int depth) {
	if(root == null) return true; 
	if(root.left == null && root.right == null) {
		if(leafDepth == 0) leafDepth = depth+1; 
		else return leafDepth == depth+1; 
	}
	return checkLevel(root.left, depth+1) && checkLevel(root.right, depth+1); 
}
