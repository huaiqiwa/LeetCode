public static boolean flag;   
static int shortDistance(TreeNode root, TreeNode a, TreeNode b)
	{
		if(root==null) return -1; 
		if(root==a || root==b) return 1; 
		int left=shortDistance(root.left, a, b);
		int right=shortDistance(root.right, a, b);
		if(left==-1 && right==-1) return -1; 
		if(left!=-1 && right!=-1)
		{
			flag=true; 
			return left+right; 
		}
		if(flag) return left==-1? right: left; 
		return left==-1? right+1: left+1; 
	}


private boolean found;

public int shortestDistance(TreeNode root, TreeNode a, TreeNode b) {
	found = false;
	return shortestDis(root, a, b);
}

private int shortestDis(TreeNode root, TreeNode a, TreeNode b) {
	if(root == null) return -1;
	if(root == a || root == b) return 1;
	int left = shortestDis(root.left, a, b);
	int right = shortestDis(root.right, a, b);
	if(left == -1 && right == -1) return -1;
	if(left != -1 && right != -1) {
		found = true;
		return left+right;
	}
	if(found) return left != -1 ? left : right;
	return left != -1 ? left+1 : right+1;
}















