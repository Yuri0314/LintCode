/**
 * 设总结点数为N，链表数为k，则时间复杂度为O(N*logk)
 * 设每个链表最长长度为n，链表数为k，则时间复杂度为O(nk*logk)
 */
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
    private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode node1, ListNode node2) {
            return node1.val - node2.val;
        }
    };
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) return null;
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), listNodeComparator);
        for (ListNode node : lists) {
            if (node != null) heap.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            tail.next = heap.remove();
            tail = tail.next;
            if (tail.next != null) heap.add(tail.next);
        }
        return dummy.next;
    }
}
