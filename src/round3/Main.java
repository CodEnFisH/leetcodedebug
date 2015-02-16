package round3;

import nonleet.*;
import round2.MaxPoint;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by codefish on 1/27/15.
 */
public class Main {
    public static void main(String[] args) {
        //testMedian();
        //testTrapRain();
        //testRotateList();
        //testReverseInt();
        //testLongestConseq();
        //testValidNum();
        //testDiv();
        //testWild();
        //testLexicalOrder();
        //testTwoDiff();
        testRecoverQuack();
    }

    public static void testMedian(){
        int[] input1 = {1,2}, input2 = {1,2};
        System.out.println(new Median().findMedianSortedArrays(input1, input2));
    }
    public static void testTrapRain(){
        int[] input = {0,2,0};
        System.out.println(new TrapRain().trap(input));
    }
    public static void testRotateList(){
        ListNode n = new ListNode(1);
        new RotateList().rotateRight(n, 99);
    }
    public static void testReverseInt(){
        System.out.println(new ReverseInt().reverse(1));
    }
    public static void testLongestConseq(){
        int[] input = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        new LongestConseq().longestConsecutive(input);
    }
    public static void testValidNum(){
        System.out.println(new ValidNumber().isNumber("2e"));
    }
    public static void testDiv(){
        System.out.println(new Divide().divide(2147483647, 3));
    }
    public static void testWild(){
        System.out.println(new WildCard().isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    }
    public static void testLexicalOrder(){
        String[] input = {"ze", "yf", "xd", "wd", "vd", "ua", "tt", "sz", "rd",
                "qd", "pz", "op", "nw", "mt", "ln", "ko", "jm", "il",
                "ho", "gk", "fa", "ed", "dg", "ct", "bb", "ba"};
        System.out.println(Arrays.toString(new LexicalOrder().getOrder(
                input
        ).toArray()));
    }
    public static void testTwoDiff(){
        int[] input = {1, 2, 4, 8};
        System.out.println(Arrays.toString(new TwoDifference().twoDifference(input, 10)));
    }
    public static void testRecoverQuack(){
        Quack<Integer> integerQuack = new Quack<Integer>();
        int[] input = {1,2,2,2,3,3,3,3,4,5,6};
        for(int i: input) integerQuack.push(i);
        System.out.println(Arrays.toString(new RecoverQuack().recoverWithDuplicate(integerQuack)));
    }
}
