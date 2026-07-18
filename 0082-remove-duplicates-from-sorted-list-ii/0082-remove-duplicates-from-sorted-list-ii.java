
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode i = dummy; // prev dummy 
        ListNode j = head;  // curr head

        while (j != null){

            if(j.next != null && j.val == j.next.val){

                while(j.next != null && j.val == j.next.val){
                    j = j.next;
                }
                i.next = j.next;
            } else{
                i = i.next;
            }
            j = j.next;
        }
        return dummy.next;
        
    }

}