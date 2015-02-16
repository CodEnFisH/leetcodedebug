package round3;

/**
 * Created by codefish on 1/31/15.
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        // corner cases: n >= len, head = null
        if(head == null) return null;
        ListNode second = head;
        int cnt = n;
        while(cnt>0){
            cnt--;
            if(second.next == null) {
                second = head;
                n %= (n - cnt);
            }
            else second = second.next;
        }
        ListNode first = head;
        while(second.next != null){
            second = second.next;
            first = first.next;
        }
        if(first.next != null) {
            second.next = head;
            head = first.next;
            first.next = null;
        }
        return head;
    }
}
