public static int log2(int n, int r) {
	if(n<r) return 0;  
	return log2(n/r, r)+1; 
}
