class Solution {
    public ListNode swapPairs(ListNode head) {
         if (head == null || head.next == null) {
        return head;
    }
    // Store the next node for recursion
    ListNode nextNode = head.next;
    // Swap the current node and the next node
    head.next = swapPairs(nextNode.next);
    nextNode.next = head;
    // Return the new head (nextNode becomes the head after swapping)
    return nextNode;
    }
}