class Solution {
    public ListNode reverseLL(ListNode head){
        ListNode cur=head,prev=null;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
    public ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast= head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode mid=middle(head);
        ListNode rev=reverseLL(mid);

        ListNode left=head;
        ListNode right=rev;

        while(right!=null){
            if(left.val!=right.val) return false;
            left=left.next;
            right=right.next;
        }
        return true;
    }
}