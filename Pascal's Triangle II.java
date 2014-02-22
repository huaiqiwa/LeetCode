//O(k) space
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result=new ArrayList<Integer>(); 
        result.add(1);
        if(rowIndex==0) return result; 
        result.add(1);
        if(rowIndex==1) return result; 
        for(int i=2; i<=rowIndex; i++)
        {
            int temp=1; 
            for(int j=1; j<i; j++)
            {
                int first=temp; 
                temp=result.get(j); 
                result.remove(j);
                result.add(j, first+temp);
            }
            result.add(1);
        }
        return result; 
    }
}


public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if(rowIndex == 0) return result;
        int preNum = 1;
        for(int i = 1; i <= result.size(); i++) {
        	if(i < result.size()) {
        	    int curNum = preNum + result.get(i);
        	    preNum = result.get(i);
        	    result.set(i, curNum);
        	} else {
        	    result.add(preNum);
        	    if(result.size() == rowIndex+1) break;
        	    i = 0;
        	    preNum = 1;
        	}
        }
        return result;
    }
}


public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for(int i = 0; i < rowIndex; i++) {
            result.add(1);
            for(int j = result.size()-2; j > 0; j--) {
                result.set(j, result.get(j)+result.get(j-1));
            }
        }
        return result;
    }
}




























