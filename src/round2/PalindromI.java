package round2;

/**
 * Created by codefish on 1/13/15.
 */
public class PalindromI {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while(i < j){
            while(i < j && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') &&
                    !(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') &&
                    !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) i++;
            while( i < j && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z') &&
                    !(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') &&
                    !(s.charAt(i) >= '0' && s.charAt(i) <= '9')) j--;
            int diff = s.charAt(i)-s.charAt(j);
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ){
                //(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){
                if( diff != 32 && diff != 0) return false;
            } else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                //(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')){
                if(diff != -32 && diff != 0) return false;
            } else {
                if(s.charAt(j) != s.charAt(i)) return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
