package nonleet;

import java.util.Random;

/**
 * Created by codefish on 2/16/15.
 */
public class RandomNode {
    Random rand = new Random();
    TreeNode ret = null;
    int k = 1;
    public TreeNode getRandomNode(TreeNode root){
        reservoirSample(root);
        return ret;
    }
    public void reservoirSample(TreeNode root){
        if(root == null) return;
        if(rand.nextInt(k++) == 0) ret = root;
        reservoirSample(root.left);
        reservoirSample(root.left);
    }
}
