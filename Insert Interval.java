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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(intervals.size()==0)
        {
            intervals.add(newInterval);
            return intervals; 
        }
        ArrayList<Interval> result=new ArrayList<Interval>(); 
        boolean flag=false; 
        for(int i=0; i<intervals.size(); i++)
        {
            Interval curInterval=intervals.get(i);
            if(curInterval.start>newInterval.end)
            {
                result.add(newInterval);
                while(i<intervals.size())
                {
                    result.add(intervals.get(i)); i++; 
                }
                flag=true; 
            }else
            if(newInterval.start>curInterval.end)
            {
                result.add(curInterval);
                
            }else
            {
                newInterval.start=Math.min(newInterval.start, curInterval.start);
                newInterval.end=Math.max(newInterval.end, curInterval.end);
            }
        }
        if(!flag) result.add(newInterval);
        return result; 
    }
}


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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
       ArrayList<Interval> result = new ArrayList<Interval>();
       int len = intervals.size();
       int pos = 0;
       while(pos < len && newInterval.start > intervals.get(pos).end) {
           result.add(intervals.get(pos));
           pos++;
       }
       if(pos < len && newInterval.start > intervals.get(pos).start) {
           newInterval.start = intervals.get(pos).start;
       }
       while(pos < len && newInterval.end >= intervals.get(pos).start) {
           pos++;
       }
       if(pos-1 >= 0 && newInterval.end < intervals.get(pos-1).end) {
           newInterval.end = intervals.get(pos-1).end;
       }
       result.add(newInterval);
       while(pos < len) {
           result.add(intervals.get(pos));
           pos++;
       }
       return result;
    }
}

























