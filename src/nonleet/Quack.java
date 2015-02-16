package nonleet;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by codefish on 2/15/15.
 */
public class Quack<T> {
    Deque<T> deque = new LinkedList<T>();
    Random random = new Random();
    Boolean lastPeekHead = null;
    public void push(T x){
        deque.push(x);
    }
    public T pop(){
        if(deque.isEmpty()) return null;
        if(lastPeekHead != null) {
            boolean isHead = lastPeekHead;
            lastPeekHead = null;
            return isHead ? deque.removeFirst() : deque.removeLast();
        } else return random.nextBoolean() ? deque.removeFirst() : deque.removeLast();
    }
    public T peek(){
        if(deque.isEmpty()) return null;
        lastPeekHead = random.nextBoolean();
        return lastPeekHead ? deque.peekFirst() : deque.peekLast();
    }
    public boolean isEmpty(){
        return deque.isEmpty();
    }
    public int size(){
        return deque.size();
    }
}
