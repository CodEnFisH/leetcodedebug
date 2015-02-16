package round3;

/**
 * Created by codefish on 2/2/15.
 */
public class MergeSortList {
    private ListNode findMid(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }
    public ListNode sort(ListNode first, ListNode last){
        if(first == null) return null;
        if(first.next == last) {
            first.next = null;
            return first;
        }
        ListNode mid = findMid(first);
        return merge(sort(first, mid), sort(mid, last));
    }
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode dummy = new ListNode(-1), tail = dummy;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                tail.next = h1;
                h1 = h1.next;
                tail = tail.next;
                tail.next = null;
            } else {
                tail.next = h2;
                h2 = h2.next;
                tail = tail.next;
                tail.next = null;
            }
        }
        if(h1 != null) tail.next = h1;
        else if(h2 != null) tail.next = h2;
        return dummy.next;
    }
}
