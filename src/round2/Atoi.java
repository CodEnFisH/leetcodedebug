package round2;

/**
 * Created by codefish on 1/19/15.
 */
public class Atoi {
    public int atoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        int neg = 1;
        int start = 0;
        if(!isValidDigit(0, str.charAt(0))) {
            if(str.charAt(0) == '+'){
                start = 1;
            } else if(str.charAt(0) == '-'){
                start = 1;
                neg = -1;
            } else return 0;
        }
        if(start == str.length()) return 0;
        int result = 0, digit;
        char c;
        for(int i = start; i < str.length(); i++){
            c = str.charAt(i);
            if(!isValidDigit(i, c)) return result*neg;
            digit = c - '0';
            //overflow check
            if(neg==-1){
                if(-result < Integer.MIN_VALUE/10) return Integer.MIN_VALUE;
            } else {
                if(result > Integer.MAX_VALUE/10) return Integer.MAX_VALUE;
            }
            result *= 10;

            //overflow check
            if(neg==-1){
                if(Integer.MIN_VALUE + digit > -result) return Integer.MIN_VALUE;
            } else {
                if(result > Integer.MAX_VALUE - digit) return Integer.MAX_VALUE;
            }
            result += digit;
        }
        return result*neg;
    }
    private boolean isValidDigit(int pos, char c){
        //if(pos == 0) return c >= '1' && c <= '9';
        //else return c >= '0' && c <= '9';
        return c >= '0' && c <= '9';
    }
}