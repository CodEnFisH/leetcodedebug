package nonleet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by codefish on 1/28/15.
 */
class UnionSet<T>{
    class UnionSetNode<T>{
        T val;
        int rank;
        UnionSetNode<T> p;
        UnionSetNode(T val){
            this.val = val;
            this.rank = 0;
            this.p = this;
        }
    }
    HashMap<T, UnionSetNode<T>> map = new HashMap<T, UnionSetNode<T>>();
    private UnionSetNode<T> find(UnionSetNode<T> node){
        if(node.p != node){
            node.p = find(node.p);
        }
        return node.p;
    }
    public T findSet(T x){
        UnionSetNode<T> node = map.get(x);
        if(node == null) makeSet(x);
        return find(map.get(x)).val;
    }

    public boolean makeSet(T x){
        if(map.containsKey(x)) return false;
        map.put(x, new UnionSetNode(x));
        return true;
    }
    public void link(T x, T y){
        UnionSetNode<T> xNode = map.get(x), yNode = map.get(y);
        if(xNode.rank > yNode.rank) {
            yNode.p= xNode;
        } else {
            xNode.p = yNode;
            if(xNode.rank == yNode.rank) yNode.rank++;
        }
    }
    public void union(T x, T y){
        link(findSet(x), findSet(y));
    }
    public void printAll(){
        for(Map.Entry<T, UnionSetNode<T>> e : map.entrySet()){
            System.out.println(e.getKey() + "->" + findSet(e.getKey()));
        }
    }
}
