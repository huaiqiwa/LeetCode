public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        int d=1; 
        for(int i=1; i<=n; i++) {
            list.add(i);
            d *= i;
        }
        
        StringBuilder sb=new StringBuilder(); 
        for(int i = n; i >= 1; i--) {
            d = d / i;
            int q = (k-1) / d;
            sb.append(list.get(q));
            list.remove(q);
            k = k - q*d;
        }
        return sb.toString(); 
    }
}


public class Solution {
    public String getPermutation(int n, int k) {
        if(k <= 0) return "";
        ArrayList<Integer> divs = new ArrayList<Integer>();
        int div = 1;
        for(int i = 1; i <= n; i++) {
        	divs.add(i);
        	div *= i;
        }
        if(k > div) return "";
        StringBuilder result = new StringBuilder();
        for(int i = n; i >= 1; i--) {
        	div /= i;
        	int index = (k-1) / div;
        	result.append(divs.get(index));
        	divs.remove(index);
        	k -= div*index;
        }
        return result.toString();
    }
}


























