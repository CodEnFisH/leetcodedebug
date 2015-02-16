package nonleet;

import java.util.Iterator;
import java.util.List;

/**
 * Created by codefish on 2/9/15.
 */
public class ZigZagIterator<T> implements Iterator<T> {
    @Override
    public boolean hasNext(){
        return nextNonEmptyItr.hasNext();
    }
    @Override
    public T next(){
        Iterator<T> nextItr = nextNonEmptyItr.next();
        T ret = nextItr.next();
        if(!nextItr.hasNext()) nextNonEmptyItr.remove();
        if(!nextNonEmptyItr.hasNext()) nextNonEmptyItr = nonEmptyItrs.iterator();
        return ret;
    }
    @Override
    public void remove(){
        //todo
    }
    private List<Iterator<T>> nonEmptyItrs;
    private Iterator<Iterator<T>> nextNonEmptyItr;
    // constructor
    public ZigZagIterator(List<Iterator<T>> iterators){
        this.nonEmptyItrs = iterators;
        Iterator<Iterator<T>> itr = nonEmptyItrs.iterator();
        while(itr.hasNext()){
            Iterator<T> next = itr.next();
            if(!next.hasNext()) next.remove();
        }
        nextNonEmptyItr = nonEmptyItrs.iterator();
    }
}