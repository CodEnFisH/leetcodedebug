package round1;

/**
 * Created by codefish on 1/5/15.
 */
import java.util.*;
public class Justify {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new LinkedList<String>();
        int len = 0, pos = 0;
        List<String> line = new LinkedList();
        while(pos < words.length){
            if(len == 0){
                line.add(words[pos]);
                len += words[pos].length();
                pos++;
            } else {
                if(len + words[pos].length() + 1 <= L){
                    line.add(words[pos]);
                    len += (1 + words[pos].length());
                    pos++;
                } else {
                    StringBuffer buf = new StringBuffer();
                    len = 0;
                    for(String item: line) len += item.length();
                    int padLen = (L-len)/(line.size()-1);
                    int firstPadExtra = L-(line.size()-1)*padLen - len;
                    StringBuffer padBuf = new StringBuffer();
                    for(int i = 0; i < padLen; i++) padBuf.append(' ');
                    String pad = padBuf.toString();
                    for(int i = 0; i < firstPadExtra; i++) padBuf.append(' ');
                    String firstPad = padBuf.toString();
                    for(int i = 0; i < line.size(); i++){
                        buf.append(line.get(i));
                        if(line.size() >= 1) {
                            if(i == 0){
                                buf.append(firstPad);
                            } else if(i < line.size()-1){
                                buf.append(pad);
                            }
                        }
                    }
                    ret.add(buf.toString());
                    line = new LinkedList<String>();
                    len = 0;
                }
            }
        }
        if(line.size() != 0){
            StringBuffer buf = new StringBuffer();
            for(int i = 0; i < line.size(); i++){
                buf.append(line.get(i));
                if(line.size() > 1 && i != line.size()-1) buf.append(' ');
            }
            ret.add(buf.toString());
        }
        return ret;
    }
}

