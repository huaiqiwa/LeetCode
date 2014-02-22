public class Solution
{
  	int [] A={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ArrayList<Integer> listOfIntegers=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>(); 
		sumOfDices(A, A.length-1, 3 , 12, listOfIntegers, results );
		for(ArrayList<Integer> list: results)
		{
			for(Integer i: list)
			{
				System.out.print(i);
			}
			System.out.println("");
		}
}

static void sumOfDices(int [] A, int index, int rest, int target, 
	ArrayList<Integer> listOfIntegers, ArrayList<ArrayList<Integer>> results )
  {
		if(index<0 || rest<=0) return ; 
		for(int i=0; i<=rest; i++)
		{
			int tempSum=i*A[index];
			if(tempSum>target)
				break; 
			else if(tempSum==target)
			{
				if(rest==i)
				{
					ArrayList<Integer> tempList=new ArrayList<Integer>(listOfIntegers);
					int counter=0; 
					while(counter!=i)
					{
						tempList.add(A[index]);
						counter++; 
					}
					results.add(tempList);
					break;
				}else
					break; 
 
			}else
			{
				ArrayList<Integer> tempList=new ArrayList<Integer>(listOfIntegers);
				int counter=0; 
				while(counter!=i)
				{
					tempList.add(A[index]);
					counter++; 
				}
				sumOfDices( A, index-1, rest-i, target-tempSum, tempList, results ); 
			}
		}
	}

//http://www.geeksforgeeks.org/dice-throw-problem/
public int findWays(int m, int n, int x) {
	if(n > x) return 0;
	int[][] table = new int[n+1][x+1];
	for(int i = 1; i <= m && i <= x; i++) {
		table[1][i] = 1;
	}
	for(int i = 2; i <= n; i++) {
		for(int j = i; j <= x; j++) {
			for(int k = 1; k <= m && i-1 <= j-k; k++) {
				table[i][j] += table[i-1][j-k];
			}
		}
	}
	return table[n][x];
}




























