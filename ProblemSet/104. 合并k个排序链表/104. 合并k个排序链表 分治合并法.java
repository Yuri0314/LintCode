/**
 * 设总结点数为N，链表数为k，则时间复杂度为O(N*logk)
 * 设每个链表最长长度为n，链表数为k，则时间复杂度为O(nk*logk)
 */
import java.util.List;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) return null;
        int l = lists.size();
        while (l > 1) {
            int idx = 0;
            for (int i = 0; i < l; i += 2) {
                if (i == l - 1) lists.set(idx++, lists.get(i));
                else lists.set(idx++, mergeTwoLists(lists.get(i), lists.get(i + 1)));
            }
            l = idx;
        }
        return lists.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 == null) ? l2 : l1;
        return dummy.next;
    }
}
