package round2;

import java.util.*;
/**
 * Created by codefish on 1/17/15.
 */
public class MaxPoint {
    public static class Point{
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
    class Line{
        int a, b, c;
        public Line(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public boolean equals(Object b){
            if(this == b) return true;
            if(b == null) return false;
            if(b instanceof Line){
                Line rhs = (Line)b;
                return this.a == rhs.a && this.b == rhs.b && this.c == rhs.c;
            }
            else return false;
        }
        public int hashCode(){
            int res = 5;
            res = res * 17 + a;
            res = res * 17 + b;
            res = res * 17 + c;
            return res;
        }
    }
    class UniquePoint{
        int x, y;
        UniquePoint() { x = 0; y = 0; }
        UniquePoint(int a, int b) { this.x = a; this.y = b; }
        public boolean equals(Object b){
            if(this == b) return true;
            if(b == null) return false;
            if(b instanceof UniquePoint){
                UniquePoint rhs = (UniquePoint)b;
                return this.x == rhs.x && this.y == rhs.y;
            }
            else return false;
        }
        @Override
        public int hashCode(){
            int res = 5;
            res = res * 17 + x;
            res = res * 17 + y;
            return res;
        }
    }
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n <= 1) return n;
        HashMap<Line, Integer> lines = new HashMap<Line, Integer>();
        HashMap<UniquePoint, Integer> ptToCnt = new HashMap<UniquePoint, Integer>();
        int max = -1;
        for(int i = 0; i < n; i++){
            UniquePoint pt = new UniquePoint(points[i].x, points[i].y);
            Integer cnt = ptToCnt.get(pt);
            if(cnt != null) ;
            else ptToCnt.put(pt, 1);
        }
        n = ptToCnt.size();
        if(n == 0) return 0;
        if(n == 1) return points.length;
        UniquePoint[] uniquePoints = new UniquePoint[ptToCnt.size()];
        ptToCnt.keySet().toArray(uniquePoints);
        for(int i = 0; i < uniquePoints.length; i++){
            for(int j = i + 1; j < uniquePoints.length; j++){
                //if(uniquePoints[i].x == points[j].x && points[i].y == points[j].y) continue;
                int a, b, c;
                Line l = createLine(uniquePoints[i], uniquePoints[j]);
                Integer cnt = lines.get(l);
                if(cnt != null) {
                    cnt += ptToCnt.get(uniquePoints[j]);
                    max = Math.max(max, cnt);
                } else {
                    cnt = ptToCnt.get(uniquePoints[i]) + ptToCnt.get(uniquePoints[j]);
                    max = Math.max(max, cnt);
                    lines.put(l, cnt);
                }
            }
        }
        return max;
    }
    public Line createLine(UniquePoint pa, UniquePoint pb){
        int a = pb.y - pa.y, b = pa.x - pb.x, c = pa.y * pb.x - pa.x * pb.y;
        int gcd = getGCD(getGCD(a, b), c);
        return new Line(a/gcd, b/gcd, c/gcd);
    }
    public int getGCD(int a, int b){
        while(b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
