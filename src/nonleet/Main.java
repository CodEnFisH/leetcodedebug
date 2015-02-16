package nonleet;

import round2.RegMatching;
import round3.WordSearch;

import java.util.*;

/**
 * Created by codefish on 1/21/15.
 */
public class Main {
    public static void main(String[] args) {
        //testWiggleSort();
        //testUnionSet();
        //testSubarraySum();
        //testUpsideDown();
        //testDivideInt();
        //testWS();
        //testZigZagItr();
        //testFlowToSea();
        //testMaxInSemiSorted();
        //testRecoverTree();
        //testAllSubTreeSum();
        //testAllFactors();
        //testSudoku();
        testCloestPolice();
    }

    public static void testUnionSet(){
        UnionSet<Integer> set = new UnionSet<Integer>();
        set.union(1,2);
        set.union(3, 2);
        set.union(4,2);
        set.union(1,3);
        set.union(7,5);
        set.union(5,6);
        set.union(9,8);
        set.printAll();
    }
    public static void testWiggleSort(){
        WiggleSort test = new WiggleSort();
        int input[] = {-5,10,5,-3,1,1,1,-2,3,-4};
        test.wiggleSort(input);
        for(int i: input)
            System.out.println(i);
    }
    public static void testSubarraySum(){
        int input[] = {1, 4, 0, 0, 3, 10, 5};
        //new SubarraySum().subarraySum(input);
        new SubarraySum().subarraySum(input, 7);
    }
    public static void testUpsideDown(){
        TreeNode root = new TreeNode(1), tmp = root;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root = root.left;
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root = root.left;
        root.left = new TreeNode(6);
        root.right = new TreeNode(7);
        dfs(new BinaryTreeUpsideDown().upsideDown(tmp));
    }
    public static void dfs(TreeNode root){
        if(root == null){
            System.out.println("#");
            return;
        }
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    public static void testDivideInt(){
        System.out.println(
                new DivideInt().divide(1026117192, -874002063)
        );
    }
    public static void testWS(){
        char[][] input = {
                {'a','b'},
                {'c','d'}
        };
        new WordSearch().exist(input, "cdba");
    }
    public static void testZigZagItr(){
        List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(1));
        List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(2,4));
        List<Integer> l3 = new LinkedList<Integer>(Arrays.asList(3,5,6));

        ZigZagIterator<Integer> itr = new ZigZagIterator<Integer>(new LinkedList<Iterator<Integer>>
                (Arrays.asList(l1.iterator(), l2.iterator(), l3.iterator())));
        while(itr.hasNext()) System.out.println(itr.next());

    }
    public static void testFlowToSea(){
        int[][] input = {
                {0,0,0,0,0,0,0},
                {0,1,2,2,2,3,5},
                {0,3,2,3,4,4,0},
                {0,2,4,5,3,1,0},
                {0,6,7,1,4,5,0},
                {0,5,1,1,2,4,0},
                {0,0,0,0,0,0,0}
        };
        LinkedList<FlowWaterToSea.Point> ret = new FlowWaterToSea().findAllPoints(input);
        for(FlowWaterToSea.Point pt: ret) System.out.println(pt.x + "," + pt.y);
    }
    public static void testMaxInSemiSorted(){
        int[] input = {5,3,3,2,2,1};
        System.out.println(new MaxInSemiSorted().findMax(input));
    }
    public static void testRecoverTree(){
        int[] child = {2,3,4}; //{2,3,4,5,6,7};
        int[] parents = {1,1,4}; //{1,1,2,2,3,3};
        TreeNode r = new RecoverTree().recoverTree(child, parents);
        if(r != null) System.out.println(r.val);
    }
    public static void testAllSubTreeSum(){
        TreeNodeWithParent[] input = new TreeNodeWithParent[6];
        input[0] = new TreeNodeWithParent(0, 1, Integer.MIN_VALUE);
        input[1] = new TreeNodeWithParent(1, 2, 0);
        input[2] = new TreeNodeWithParent(2, 2, 0);
        input[3] = new TreeNodeWithParent(3, 4, 1);
        input[4] = new TreeNodeWithParent(4, 5, 1);
        input[5] = new TreeNodeWithParent(5, 3, 2);
        HashMap<Integer, Integer> result = new AllSubTreeSub().allSum(input);
        for(Map.Entry<Integer, Integer> entry: result.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
    public static void testAllFactors(){
        int[] input = {2, 3, 7};
        System.out.println(Arrays.toString(new AllFactors().allFactor(input).toArray()));
    }

    public static void testSudoku(){
        char[][] input = {
                "..9748...".toCharArray(),
                "7........".toCharArray(),
                ".2.1.9...".toCharArray(),
                "..7...24.".toCharArray(),
                ".64.1.59.".toCharArray(),
                ".98...3..".toCharArray(),
                "...8.3.2.".toCharArray(),
                "........6".toCharArray(),
                "...2759..".toCharArray()
        };
        new SodukuSolver().solveSudoku(input);
    }

    public static void testCloestPolice(){
        int M = Integer.MAX_VALUE;
        /*
        int[][] input = {
                {M,  M,  M,  M},
                {-1, -1, -1, M},
                {M,  M,  M,  M},
                {M, -1, -1, -1},
                {M,  M,  M,  0},
        };
        */
        int[][] input = {
                {-1, -1, -1, -1, -1},
                {0, -1,  M, M, -1},
                {M, -1, -1, -1, -1},
                {M, -1, -1, M, -1},
                {M, M,   M, M, -1},
        };
        new ClosestPolices().findCloestPolice(input);
        for(int[] arr: input)
        System.out.println(Arrays.toString(arr));
    }
}
