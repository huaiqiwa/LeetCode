public class Solution {
    class Pair
    {
        int i; 
        int j; 
        Pair(int iN, int jN)
        {
            i=iN; j=jN; 
        }
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Integer, ArrayList<Pair>> map=new HashMap<Integer, ArrayList<Pair>>();
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>(); 
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
        for(int i=0; i<num.length; i++)
        {
            for(int j=0; j<num.length; j++)
            {
                if(i==j) continue; 
                int sum=num[i]+num[j];
                if(!map.containsKey(sum))
                {
                    ArrayList<Pair> list=new ArrayList<Pair>(); 
                    list.add(new Pair(i, j));
                    map.put(sum, list);
                }else
                {
                    ArrayList<Pair> list=map.get(sum);
                    boolean val=true; 
                    for(Pair t: list)
                    {
                        if(!valNum(num[t.i], num[t.j], num[i], num[j]))
                        {
                            val=false; break; 
                        }
                    }
                    if(val)
                    {
                        list.add(new Pair(i, j));
                        map.put(sum, list);
                    }

                }
                if(map.containsKey(target-sum))
                {
                    ArrayList<Pair> first=map.get(target-sum);
                    Pair second=new Pair(i, j);
                    for(Pair fp: first)
                    {
                            if(valid(fp.i, fp.j, second.i, second.j))
                            {
                                int []array={num[fp.i], num[fp.j], num[second.i], num[second.j]};
                                Arrays.sort(array);
                                ArrayList<Integer> subList=new ArrayList<Integer>();
                                for(int p=0; p<4; p++)
                                {
                                    subList.add(array[p]);
                                }
                                if(!set.contains(subList))
                                {
                                    result.add(subList);
                                    set.add(subList);
                                }
                            }
                    }
                }
            }
        }
        return result; 
    }
    boolean valNum(int i, int j, int p, int q)
    {
        if(i==p && j==q) return false; 
        if(j==p && i==q) return false; 
        return true; 
    }
    boolean valid(int i, int j, int p, int q)
    {
        if(i==p||i==q||j==p||j==q) return false; 
        return true; 
    }
}


public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if(len < 4) return results;
        
        Arrays.sort(num);
        for(int i = 0; i < len-3; i++) {
        	if(i != 0 && num[i] == num[i-1]) continue;
        	int sum1 = target - num[i];
        	for(int j = i+1; j < len-2; j++) {
        		if(j != i+1 && num[j] == num[j-1]) continue;
        		int sum2 = sum1 - num[j];
        		int start = j+1, end = len-1;
        		while(start < end) {
        			int sum3 = num[start] + num[end];
        			if(sum3 == sum2) {
        				ArrayList<Integer> result = new ArrayList<Integer>();
        				result.add(num[i]);
        				result.add(num[j]);
        				result.add(num[start]);
        				result.add(num[end]);
        				results.add(result);
        				start++;
        				while(start < end && num[start] == num[start-1]) start++;
        				end--;
        				while(start < end && num[end] == num[end+1]) end--;
        			} else if(sum3 > sum2) end--;
        			else start++; 
        		}
        	}
        }
        return results;
    }
}





































