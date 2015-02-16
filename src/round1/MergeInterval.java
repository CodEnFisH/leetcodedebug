package round1;
import java.util.*;

/**
 * Created by codefish on 1/4/15.
 */
public class MergeInterval {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class IntervalComparator implements Comparator<Interval> {

        public int compare(Interval a, Interval b){
            if(a.start < b.start) return -1;
            if(a.start > b.start) return 1;
            if(a.end < b.end) return -1;
            if(a.end > b.end) return 1;
            return 0;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new LinkedList<Interval>();
        if(intervals == null || intervals.size() == 0) return ret;
        Collections.sort(intervals, new IntervalComparator());

        Interval current = null;
        for(Interval i: intervals){
            if(current == null){
                current = new Interval(i.start, i.end);
            } else {
                if(i.start > current.end){
                    ret.add(current);
                    current = new Interval(i.start, i.end);
                } else {
                    current.end = Math.max(current.end, i.end);
                }
            }
        }
        return ret;
    }
}
