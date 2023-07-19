class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        int size = n / k;
        int extras = n % k;
        int ctr = 1 , idx = 0;
        ListNode prev = head;
        ListNode curr = head;
        while(curr != null){
            if(ctr == size + (extras > 0 ? 1 : 0)){
                extras--;
                temp = curr.next;
                curr.next = null;
                ans[idx++] = prev;
                curr = prev = temp; 
                ctr = 1;
            }else{
                ctr++;
                curr = curr.next;
            }
        }
        return ans; 
    } 
}