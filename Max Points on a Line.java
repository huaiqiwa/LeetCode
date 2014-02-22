/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
		int result = 0;
		int len = points.length;
		Map<Double, Integer> map = new HashMap<Double, Integer>();
		for (int i = 0; i < len; i++) {
			int invalidK = 0;
			int dup = 0;
			for (int j = i+1; j < len; j++) {
				if (points[j].x == points[i].x) {
					if (points[j].y == points[i].y) dup++;
					else invalidK++;
					continue;
				}
				double k = (points[j].y == points[i].y) ? 
							0.0 : (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
				if (map.containsKey(k)) map.put(k, map.get(k)+1);
				else map.put(k, 1);
			}
			for (int count : map.values()) {
				result = Math.max(result, count+dup+1);
			}
			result = Math.max(result, invalidK+dup+1);
			map.clear();
		}
		return result;
    }
}

//Assume that x, y are integers, otherwise we need to do point[i].x - point[j].x < epsilon(0.000001)
public class Solution {
    public int maxPoints(Point[] points) {
		int result = 0;
		int len = points.length;
		HashMap<Double, Integer> lineCount = new HashMap<Double, Integer>();
		int maxK;
		boolean maxInvalidK = false;
		int maxPointIndex = -1;
		for(int i = 0; i < len; i++) {
			int invalidK = 0;
			int dup = 0;
			for(int j = i+1; j < len; j++) {
				if(points[i].x == points[j].x) {
					if(points[i].y == points[j].y) dup++;
					else invalidK++;
					continue;
				}
				double k = (points[i].y == points[j].y) ? 
						    0.0 : (double)(points[j].y-points[i].y)/(points[j].x-points[i].x);
				if(lineCount.containsKey(k)) lineCount.put(k, lineCount.get(k)+1);
				else lineCount.put(k, 1);
			}
			for(double k : lineCount.keySet()) {
				int count = lineCount.get(k);
				if(count+dup+1 > result) {
					maxInvalidK = false;
					result = count+dup+1;
					maxK = k;
					maxPointIndex = i;
				}
			}
			if(invalidK+dup+1 > result) {
				result = invalidK+dup+1;
				maxInvalidK = true;
				maxPointIndex = i;
			}
			lineCount.clear();
		}
		//could use maxK and points[maxPointIndex] to calculate the line with max points
		return result;
    }
}

































