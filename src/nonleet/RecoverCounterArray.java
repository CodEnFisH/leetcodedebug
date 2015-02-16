package nonleet;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by codefish on 1/21/15.
 */
class BST {
    TreeNode root;
    public BST(){
    }
    public void insert(int v){
        if(root == null) root = new TreeNode(v);
        else insertToNode(root, v);
    }
    public void insertToNode(TreeNode root, int v){
        if(v <= root.val) {
            if(root.left == null) {
                root.left = new TreeNode(v);
                root.leftSize = 1;
            } else {
                insertToNode(root.left, v);
                root.leftSize++;
            }
        } else {
            if(root.right == null){
                root.right = new TreeNode(v);
                root.rightSize = 1;
            } else {
                insertToNode(root.right, v);
                root.rightSize++;
            }
        }
    }

    // insert the k-th smallest element into the bst
    // k is 1-based, v is assosiated value
    public void insertKth(int k, int v){
        if(root == null) {
            root = new TreeNode(v);
            return;
        }
        insertKth(root, k, v);
    }
    private void insertKth(TreeNode root, int k, int v){
        if(k == 1) {
            while(root.left != null){
                root.leftSize++;
                root = root.left;
            }
            root.left = new TreeNode(v);
            root.leftSize = 1;
            return;
        }
        if(k == root.leftSize + root.rightSize + 2){
            while(root.right != null){
                root.rightSize++;
                root = root.right;
            }
            root.right = new TreeNode(v);
            root.rightSize = 1;
            return;
        }
        if(root.leftSize < k - 1){
            insertKth(root.right, k - root.leftSize - 1, v);
            root.rightSize++;
        } else {
            insertKth(root.left, k, v);
            root.leftSize++;
        }
    }
    /*
    public void printAll(){
        StringBuffer buf = new StringBuffer();
        dfs(root, buf);
        System.out.println(buf.toString());
    }
    */
    public void dfs(TreeNode root, LinkedList<Integer> result){
        if(root == null) return;
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }
}

public class RecoverCounterArray {
    public void recover(int[] a){
        int n = a.length;
        BST tree = new BST();
        for(int i = n-1; i >= 0; i--){
            tree.insertKth(a[i] + 1, i );
        }
        LinkedList<Integer> ret = new LinkedList<Integer>();
        tree.dfs(tree.root, ret);
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            b[ret.get(i)] = n - i;
        }
        System.out.println(Arrays.toString(b));
    }
}
