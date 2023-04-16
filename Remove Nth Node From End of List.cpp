//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {//very conceptual question solution in one pass is very crucial one so we always this concept shoud be kept in mind;
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        //optimal approach
        // n--;
            ListNode* start=new ListNode();
            start->next=head;
            ListNode *fast=start,*slow=start;
            while(n--) fast=fast->next;
            while(fast->next!=NULL){
                slow=slow->next;
                fast=fast->next;
            }
            slow->next=slow->next->next;
            return start->next;
    }
};
