public class Solution {
    public void nextPermutation(int[] num) {
        int i;
        for(i = num.length-1; i > 0; i--) {
        	if(num[i-1] < num[i]) break;
        }
        reverse(num, i, num.length-1);
        
        if(i == 0) return;
        int j = i;
        while(num[i-1] >= num[j]) j++;
        swap(num, i-1, j);
    }
    
    private void reverse(int[] num, int i, int j) {
        while(i < j) {
        	swap(num, i, j);
        	i++;
        	j--;
        }
    }
    
    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
