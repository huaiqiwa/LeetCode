/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	if(intervals.size() == 0) return intervals;
        Comparator<Interval> comparator = new Comparator<Interval>() {
        	public int compare(Interval i1, Interval i2) {
        		return i1.start-i2.start;
        	}
        };
        Collections.sort(intervals, comparator);
        ArrayList<Interval> result = new ArrayList<Interval>();
        int curStart = intervals.get(0).start, curEnd = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
        	Interval cur = intervals.get(i);
        	if(curEnd < cur.start) {
        		result.add(new Interval(curStart, curEnd));
        		curStart = cur.start;
        		curEnd = cur.end;
        	} else if(curEnd < cur.end){
        		curEnd = cur.end;
        	}
        }
        result.add(new Interval(curStart, curEnd));
        return result;
    }
}