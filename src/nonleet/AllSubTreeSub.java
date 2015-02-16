package nonleet;


import java.util.*;

/**
 * Created by codefish on 2/11/15.
 */
class TreeNodeWithParent {
    int id, val, parentId;
    public TreeNodeWithParent(int id, int val, int parentId){
        this.id = id; this.val = val; this.parentId = parentId;
    }
}
public class AllSubTreeSub {
    int NULLID = Integer.MIN_VALUE;
    public HashMap<Integer, Integer> allSum(TreeNodeWithParent[] nodes){
        HashMap<Integer, TreeNodeWithParent> idToNode = new HashMap<Integer, TreeNodeWithParent>();
        HashMap<Integer, Integer> ret = new HashMap<Integer, Integer>(), prevLev = new HashMap<Integer, Integer>(),
                lev = new HashMap<Integer, Integer>();
        HashSet<Integer> parentIds = new HashSet<Integer>();
        for(TreeNodeWithParent n: nodes){
            idToNode.put(n.id, n);
            parentIds.add(n.parentId);
        }
        for(Map.Entry<Integer, TreeNodeWithParent> entry: idToNode.entrySet()){
            if(!parentIds.contains(entry.getKey())){
                lev.put(entry.getKey(), entry.getValue().val);
            }
        }
        while(!lev.isEmpty()){
            ret.putAll(lev);
            prevLev = lev;
            lev = new HashMap<Integer, Integer>();
            for(Map.Entry<Integer, Integer> entry: prevLev.entrySet()){
                int parentId = idToNode.get(entry.getKey()).parentId;
                if(parentId != NULLID) {
                    int sum = lev.containsKey(parentId) ? lev.get(parentId) + entry.getValue() : entry.getValue();
                    lev.put(parentId, sum);
                }
            }
            for(Map.Entry<Integer, Integer> entry: lev.entrySet()){
                lev.put(entry.getKey(), entry.getValue() + idToNode.get(entry.getKey()).val);
            }
        }
        return ret;
    }
}
