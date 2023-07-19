class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode curr = ans; 
        int m = 0;
        while(l1 != null && l2 != null){
            m = l1.val + l2.val + m/10;
            if(m>=10){
                curr.next = new ListNode(m%10);
                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
            }else{
                curr.next = new ListNode(m);
                curr = curr.next;
                l1 = l1.next;
                l2 = l2.next;
                m = 0;

            }
        }
        while(l1 != null ){
            m = l1.val + m/10;
            if(m>=10){
                curr.next = new ListNode(m%10);
                curr = curr.next;
                l1 = l1.next;
            }else{
                curr.next = new ListNode(m);
                curr = curr.next;
                l1 = l1.next;
                m = 0;

            }
        }
        while(l2 != null){
            m = l2.val + m/10;
            if(m>=10){
                curr.next = new ListNode(m%10);
                curr = curr.next;
                l2 = l2.next;
            }else{
                curr.next = new ListNode(m);
                curr = curr.next;
                l2 = l2.next;
                m = 0;
            }
        }
        if(m>0){
            curr.next = new ListNode(m/10);
            curr = curr.next; 
        }
        return ans.next;
    }
}