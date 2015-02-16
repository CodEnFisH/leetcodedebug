package nonleet;

/**
 * Created by codefish on 2/3/15.
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDown(TreeNode root){
        if(root.left == null && root.right == null) return root;
        TreeNode lc = upsideDown(root.left), p = lc;
        while(p.left != null) p = p.right;
        p.left = root.right;
        p.right = root;
        root.left = null; root.right = null;
        return lc;
    }
}
