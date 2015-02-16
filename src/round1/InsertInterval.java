package round1;
import java.util.*;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval  {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e;}
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = 0, end = -1;
        for(int i = 0; i < intervals.size(); i++){
            Interval next = intervals.get(i);
            if(next.end >= newInterval.start){
                start = i;
                break;
            }
        }
        if(intervals.get(start).start > newInterval.end){
            intervals.add(0, newInterval);
            return intervals;
        }
        for(int i = 0; i < intervals.size(); i++){
            Interval next = intervals.get(i);
            if(next.start > newInterval.end){
                end = i;
                break;
            }
        }
        if(end == -1){
            end = intervals.size()-1;
        }
        int lb = Math.min(newInterval.start, intervals.get(start).start);
        int ub = Math.max(newInterval.end, intervals.get(end-1).end);
        intervals.subList(start, end).clear();
        intervals.add(start, new Interval(lb, ub));
        return intervals;
    }
}
