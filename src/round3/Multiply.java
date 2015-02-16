package round3;

/**
 * Created by codefish on 1/27/15.
 */
import java.util.*;
public class Multiply {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuffer result = new StringBuffer(num1.length() + num2.length() + 2);
        for(int i = num2.length() - 1; i >= 0; i--){
            int a = num2.charAt(i) - '0';
            if(a != 0){
                StringBuffer row = new StringBuffer(num1.length() + 1);
                int c = 0;
                for(int j = 0; j < num2.length() - i - 1; j++) row.append(0);
                for(int j = num1.length() - 1; j >= 0; j--){
                    int product = a * (num1.charAt(j) - '0') + c;
                    if(product >= 10){
                        c = product / 10;
                        product %= 10;
                    } else {
                        c = 0;
                    }
                    row.append(product);
                }
                if(c != 0) row.append(c);
                c = 0;
                StringBuffer newSum = new StringBuffer(Math.max(row.length(), result.length()) + 1);
                int p = 0, q = 0;
                while(p < result.length() && q < row.length()){
                    int d = result.charAt(p) - '0' + row.charAt(q) - '0' + c;
                    if(d >= 10){
                        d -= 10;
                        c = 1;
                    } else c = 0;
                    newSum.append(d);
                    p++;
                    q++;
                }
                while(p < result.length()){
                    int d = result.charAt(p) - '0' + c;
                    if(d >= 10){
                        d -= 10;
                        c = 1;
                    } else c = 0;
                    newSum.append(d);
                    p++;
                }
                while(q < row.length()){
                    int d = row.charAt(q) - '0' + c;
                    if(d >= 10){
                        d -= 10;
                        c = 1;
                    } else c = 0;
                    newSum.append(d);
                    q++;
                }
                if(c != 0) newSum.append(1);
                result = newSum;
            }
        }
        return result.reverse().toString();
    }
}
