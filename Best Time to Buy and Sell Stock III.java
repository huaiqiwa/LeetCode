public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length==0) return 0; 
        int [] first=new int[prices.length]; //first[i] means the maximum profit before i
        int [] second=new int[prices.length]; //second[i] means the maximum profit after i
        int min=prices[0]; 
        first[0]=0;  
        second[prices.length-1]=0;
        int profit=0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]<=min)
            {
                min=prices[i];
                first[i]=profit; 
            }else
            {
                profit=Math.max(profit, prices[i]-min);
                first[i]=profit;
            }
        }
        int max=prices[prices.length-1];
        profit=0; 
        for(int i=prices.length-2; i>=0; i-- )
        {
          if(prices[i]>=max)
          {
              max=prices[i];
              second[i]=profit; 
          }else
          {
              profit=Math.max(profit, max-prices[i]);
              second[i]=profit; 
          }
        }
        profit=0;
        for(int i=0; i<prices.length; i++)
        {
            if(first[i]+second[i]>profit) profit=first[i]+second[i];
        }
        return profit; 
    }
}


public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        int[] profit = new int[n];
        int min = prices[0];
        for(int i = 1; i < n; i++) {
        	profit[i] = prices[i] - min;
        	min = Math.min(min, prices[i]);
        }
        int max = prices[n-1];
        int secondMaxProfit = 0;
        int totalMaxProfit = profit[n-1];
        for(int i = n-2; i >= 0; i--) {
        	secondMaxProfit = Math.max(secondMaxProfit, max-prices[i]);
        	totalMaxProfit = Math.max(totalMaxProfit, profit[i]+secondMaxProfit);
        	max = Math.max(max, prices[i]);
        }
        return totalMaxProfit;
    }
}
































