//https://practice.geeksforgeeks.org/problems/subtraction-in-linked-list/1
//https://course.acciojob.com/idle?question=b42a7f80-83b5-416e-aec0-98607b1dc9af
class Solution
{
    static int length(Node node){
      int cnt=0;
      while(node!=null) {
          node=node.next;
          cnt++;
      }
      return cnt;
  }
    static Node reverse(Node head){
      Node prev=null;
      Node cur=head;
      Node ahead=null;
      while(cur!=null){
          ahead=cur.next;
          cur.next=prev;
          prev=cur;
          cur=ahead;
      }
      return prev;
    }
    static Node subLinkedList(Node l1, Node l2)
    {
        // code here
    while(l1!=null && l1.data==0)l1=l1.next;
    while(l2!=null && l2.data==0)l2=l2.next;
    int n1=length(l1);
    int n2=length(l2);
    // considering l1>l2 in length
    if(n2>n1){
        // made l2 is first linked list
        Node temp=l1;
        l1=l2;
        l2=temp;
    }else{
        if(n1==n2){
            Node temp1=l1;
            Node temp2=l2;
            while(temp1!=null && temp1.data==temp2.data){
                temp1=temp1.next;
                temp2=temp2.next;
            }
            if(temp1!=null && temp1.data < temp2.data){
                Node temp=l1;
                l1=l2;
                l2=temp;
            }
            if(temp1==null){
                return new Node(0);
            }
        }
    }
      l1=reverse(l1);
      l2=reverse(l2);
    //   assume head1 linked is resultant linked list
    // int cnt=0;
    int carry=0;
    // substracting the linked list 
    Node result=null;
    while(l1!=null){
        // cnt++;
        l1.data+=carry;
        int b=0;
        if(l2!=null) b=l2.data;
        if(l1.data<b){
            l1.data=l1.data+10;
            carry=-1;
        }else{
            carry=0;
        }
        
        Node cur=new Node(l1.data-b);
        cur.next=result;
        result=cur;
        l1=l1.next;
        if(l2!=null)l2=l2.next;
    }
    while(result!=null && result.data==0) result=result.next;
    return result;
    }
}
