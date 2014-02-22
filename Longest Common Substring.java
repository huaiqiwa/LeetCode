public class Solution
{
public static int maxNum; 
public static void main(String[] args) {

  	String s1="BCDEQ"; 
		String s2="ABPQC";
		maxNum=0; 
		int [][]AB=new int [s1.length()][s2.length()];
		longestCommonSubstring(AB, 0, 0,  s1, s2);
		System.out.println(maxNum);
}


static int longestCommonSubstring(int [][]AB, int i, int j, String s1, String s2)
  {
		if(i>=s1.length() || j>=s2.length()) return 0; 
		if(AB[i][j]!=0) return AB[i][j]; 	
		if(s1.charAt(i)==s2.charAt(j))
		{
			AB[i][j]=1+longestCommonSubstring(AB, i+1, j+1, s1, s2);
			maxNum=Math.max(maxNum, AB[i][j]);
		}else
		{
			AB[i][j]=Math.max(longestCommonSubstring(AB, i+1, j, s1, s2), longestCommonSubstring(AB, i, j+1, s1, s2));
		}
		return AB[i][j];
	}

}


public int longestCommonSubstring(String s1, String s2) {
	if(s1.length() < s2.length()) {
		String temp = s1;
		s1 = s2;
		s2 = temp;
	}
	int l1 = s1.length(), l2 = s2.length();
	int[] LCS = new int[l2+1];
	int result = 0;
	for(int i = 1; i <= l1; i++) {
		for(int j = l2; j >= 1; j--) {
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				LCS[j] = LCS[j-1] + 1;
				result = Math.max(result, LCS[j]);
			} else {
				LCS[j] = 0;
			}
		}
	}
	return result;
}





























