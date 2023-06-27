//https://course.acciojob.com/idle?question=3ef6a7a6-3c66-4508-9562-1ae709a7c501
import java.util.*;

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

class LinkedList {
    Node head, tail;

    void push(Node new_node) {
        if (head == null && tail == null) {
            head = tail = new_node;
            return;
        }
        tail.next = new_node;
        tail = new_node;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    public Node reverseKGroup(Node head, int k) {
        //Write code here
		if(head==null) return null;
		Node prev=null;
		Node curr=head;
		Node next=null;
		int count=0;
		while(count<k && curr!=null){
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			count++;
		}
		if(count<k){
			while(count>0){
				count--;
				curr=prev;
				prev=prev.next;
				curr.next=next;
				next=curr;
			}
			return head;
		}else{
			head.next=reverseKGroup(curr,k);
			return prev;
		}
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        LinkedList llist = new LinkedList();
        int h1 = sc.nextInt();
        Node head = new Node(h1);
        llist.push(head);
        for (int i = 1; i < n; i++) {
            int data = sc.nextInt();
            llist.push(new Node(data));
        }
        Solution Obj = new Solution();
        head = Obj.reverseKGroup(head, k);
        llist.printList(head);
        sc.close();
    }
}
