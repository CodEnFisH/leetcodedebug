package round2;

/**
 * Created by codefish on 1/21/15.
 */
import java.util.*;
public class SimplifiedPath {
    public String simplifyPath(String path) {
        int start = path.indexOf('/'), end = path.indexOf('/', start + 1);
        LinkedList<String> items = new LinkedList<String>();
        while(end != -1){
            String next = path.substring(start + 1, end);
            if(next.equals("..")){
                if(items.isEmpty()){
                    items.add(next);
                } else items.removeLast();
            } else if(!next.equals(".") && !next.equals("")){
                items.add(next);
            }
            start = end;
            end = path.indexOf('/', start + 1);
        }
        String ret = "";
        for(String item: items){
            ret += ("/" + ret);
        }
        return ret;
    }
}