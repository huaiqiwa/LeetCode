public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(numRows<=0) return result; 
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        result.add(list); 
        for(int i=1; i<numRows; i++)
        {
            ArrayList<Integer> subResult=new ArrayList<Integer>();
            subResult.add(1);
            ArrayList<Integer> preList=result.get(result.size()-1);
            for(int j=0; j<preList.size()-1; j++)
            {
                subResult.add(preList.get(j)+preList.get(j+1));
            }
            subResult.add(1);
            result.add(subResult);
        }
        return result; 
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0) return results;
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        results.add(result);
        for(int i = 1; i < numRows; i++) {
        	ArrayList<Integer> preresult = results.get(results.size()-1);
        	result = new ArrayList<Integer>();
        	for(int j = 0; j <= preresult.size(); j++) {
        		int curNum = 0;
        		if(j-1 >= 0) curNum += preresult.get(j-1);
        		if(j < results.size()) curNum += preresult.get(j);
        		result.add(curNum);
        	}
        	results.add(result);
        }
        return results;
    }
}































