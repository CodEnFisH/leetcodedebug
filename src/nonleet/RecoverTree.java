package nonleet;

import java.util.HashMap;
import java.util.HashSet;

public class RecoverTree {
    HashMap<Integer, TreeNode> idToNode = new HashMap<Integer, TreeNode>();
    TreeNode root = null;
    HashSet<Integer> nonRoots = new HashSet<Integer>();
    public TreeNode recoverTree(int[] childId, int[] parentId){
        int n = childId.length;
        for(int i = 0; i < n; i++){
            TreeNode child = idToNode.containsKey(childId[i]) ? idToNode.get(childId[i]) :
                    new TreeNode(childId[i]);
            TreeNode parent = idToNode.containsKey(parentId[i]) ? idToNode.get(parentId[i]) :
                    new TreeNode(parentId[i]);
            if(parent.left == null) parent.left = child;
            else parent.right = child;
            idToNode.put(childId[i], child);
            idToNode.put(parentId[i], parent);
            nonRoots.add(childId[i]);
        }

        /*
        for(int i = 0; i < n; i++) if(!nonRoots.contains(parentId[i])) return idToNode.get
                (parentId[i]);
        return null;
        */
        for(int i = 0; i < n; i++) if(!nonRoots.contains(parentId[i])) {
            root = idToNode.get(parentId[i]);
            break;
        }
        System.out.println(check(root, idToNode));
        return root;
    }
    private boolean loop = false;
    private boolean check(TreeNode root, HashMap<Integer, TreeNode> idToNode){
        if(root == null) return false; // there must be one and only one node which is in parent
        // set but not in children set
        HashSet<Integer> visited = new HashSet<Integer>();
        dfs(root, visited);
        return !loop && visited.size() == idToNode.size();
    }
    private void dfs(TreeNode root, HashSet<Integer> visited){
        visited.add(root.val);
        if(root.left != null){
            if(visited.contains(root.left.val)) {
                loop = true;
                return;
            } else dfs(root.left, visited);
        }
        if(root.right != null) {
            if(visited.contains(root.right.val)){
                loop = true;
                return;
            } else dfs(root.right, visited);
        }
    }
}
