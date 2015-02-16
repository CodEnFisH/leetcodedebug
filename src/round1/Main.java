package round1; /**
 * Created by codefish on 1/4/15.
 */
import round1.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        MaxRectangle test = new MaxRectangle();
        char[][] input = {  "01".toCharArray(),
                            "10".toCharArray()
                        };
        test.maximalRectangle(input);
        /*
        char[][] input = {  "..9748...".toCharArray(),
                            "7........".toCharArray(),
                            ".2.1.9...".toCharArray(),
                            "..7...24.".toCharArray(),
                            ".64.1.59.".toCharArray(),
                            ".98...3..".toCharArray(),
                            "...8.3.2.".toCharArray(),
                            "........6".toCharArray(),
                            "...2759..".toCharArray()
        };
        /*
        for(String s: l){
            System.out.println(s);
        }
        */
    }
}
