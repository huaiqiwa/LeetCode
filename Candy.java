public class Solution {
    public int candy(int[] ratings) {
        int min = ratings.length;
        int[] candy = new int[ratings.length];
        int count = 0;
        for(int i = 1; i < ratings.length; i++) {
        	if(ratings[i-1] < ratings[i]) count++;
        	else count = 0;
        	candy[i] = count; 
        }
        count = 0;
        for(int i = ratings.length-2; i >= 0; i--) {
        	if(ratings[i] > ratings[i+1]) count++;
        	else count = 0;
        	min += Math.max(count, candy[i]);
        }
        min += candy[ratings.length-1];
        return min;
    }
}